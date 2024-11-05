package com.example.bookingservice.command;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookingservice.command.model.CreateBookingRequest;
import com.example.bookingservice.command.service.BookingCommandService;
import com.example.bookingservice.query.model.BookingResponse;

@RestController
@RequestMapping("/api/commands/bookings")
public class CommandController {
    private final BookingCommandService bookingCommandService;

    public CommandController(BookingCommandService bookingCommandService) {
        this.bookingCommandService = bookingCommandService;
    }

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@RequestBody CreateBookingRequest request) {
        BookingResponse response = bookingCommandService.createBooking(request);
        return ResponseEntity.ok(response);
    }

       @PostMapping("/upload-document")
    public ResponseEntity<String> uploadDocument(
            @RequestParam("file") MultipartFile file,
            @RequestParam("bookingId") String bookingId) {
        try {
            bookingCommandService.saveBookingDocument(file, bookingId);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
            
        }
    }   
}
