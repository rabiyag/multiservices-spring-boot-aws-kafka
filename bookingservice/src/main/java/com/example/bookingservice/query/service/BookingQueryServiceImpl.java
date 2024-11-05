package com.example.bookingservice.query.service;
import com.example.bookingservice.command.model.BookingCommand;
import com.example.bookingservice.query.model.BookingResponse;
import com.example.bookingservice.repository.BookingRepository;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookingQueryServiceImpl implements BookingQueryService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingResponse getBookingById(String id) {
        BookingCommand booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found")); // Handle booking not found
        return convertToResponse(booking);
    }

    @Override
    public List<BookingResponse> getAllBookings() {
        List<BookingCommand> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private BookingResponse convertToResponse(BookingCommand booking) {
        return new BookingResponse(
            booking.getBookingId(),
            booking.getUserId(),
            booking.getTravelDetails(),
            booking.getBookingDate(),
            booking.getStatus()
        );
    }
}
