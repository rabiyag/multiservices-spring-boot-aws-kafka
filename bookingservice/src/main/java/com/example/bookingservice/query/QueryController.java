package com.example.bookingservice.query;

import com.example.bookingservice.query.model.BookingResponse;
import com.example.bookingservice.query.service.BookingQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class QueryController {

    @Autowired
    private BookingQueryService bookingQueryService;

    // Endpoint to get a booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable String id) {
        BookingResponse bookingResponse = bookingQueryService.getBookingById(id);
        return ResponseEntity.ok(bookingResponse);
    }

    // Endpoint to get all bookings
    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        List<BookingResponse> bookings = bookingQueryService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}
