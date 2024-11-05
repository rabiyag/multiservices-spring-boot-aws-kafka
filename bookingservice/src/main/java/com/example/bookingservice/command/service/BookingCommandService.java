package com.example.bookingservice.command.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.bookingservice.command.model.CreateBookingRequest;
import com.example.bookingservice.query.model.BookingResponse;

public interface BookingCommandService {

    BookingResponse createBooking(CreateBookingRequest request);

    void saveBookingDocument(MultipartFile file, String bookingId) throws IOException;
}
