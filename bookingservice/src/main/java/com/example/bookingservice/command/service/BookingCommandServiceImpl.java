package com.example.bookingservice.command.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.bookingservice.command.model.BookingCommand;
import com.example.bookingservice.command.model.CreateBookingRequest;
import com.example.bookingservice.command.model.BookingCommand.BookingStatus;
import com.example.bookingservice.event.BookingEvent;
import com.example.bookingservice.event.BookingEventProducer;
import com.example.bookingservice.query.model.BookingResponse;
import com.example.bookingservice.repository.BookingRepository;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BookingCommandServiceImpl implements BookingCommandService {

    private final BookingRepository bookingRepository;
    private final BookingEventProducer bookingEventProducer;

    private final AmazonS3 amazonS3;
    
    @Autowired
    public BookingCommandServiceImpl(BookingRepository bookingRepository, BookingEventProducer bookingEventProducer, AmazonS3 amazonS3) {
        this.bookingRepository = bookingRepository;
        this.bookingEventProducer = bookingEventProducer;
        this.amazonS3 = amazonS3;
    }

    @Override
    @Transactional
    public BookingResponse createBooking(CreateBookingRequest request) {
       

         // Create a new Booking object from the request
         BookingCommand booking = new BookingCommand();

         booking.setUserId(request.getUserId());

         booking.setTravelDetails(request.getTravelDetails());
        
         booking.setBookingDate(LocalDateTime.parse(request.getTravelDate(), DateTimeFormatter.ISO_LOCAL_DATE_TIME) ); // Assuming you have this field
         booking.setStatus(BookingStatus.PENDING); // Set default status or implement your own logic
 
         // Save the booking to the repository
         BookingCommand savedBooking = bookingRepository.save(booking);
 
         // Optionally, send an event to Kafka (or any other messaging system)
         bookingEventProducer.sendBookingEvent(new BookingEvent(savedBooking.getBookingId(), savedBooking.getUserId(), savedBooking.getTravelDetails(), savedBooking.getBookingDate(), savedBooking.getStatus()));
 
         // Create and return a BookingResponse object
         return new BookingResponse(
             savedBooking.getBookingId(),
             savedBooking.getUserId(),
             savedBooking.getTravelDetails(),
             savedBooking.getBookingDate(),
             savedBooking.getStatus()
         );
     }
    

     @Override
     public void saveBookingDocument(MultipartFile file, String bookingId) throws IOException {
        String bucketName = "your-s3-bucket";
        String fileName = "booking-documents/" + bookingId + "/" + file.getOriginalFilename();
        
        try (InputStream fileStream = file.getInputStream()) {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());

            amazonS3.putObject(bucketName, fileName, fileStream, metadata);
        }
    }
}
 
