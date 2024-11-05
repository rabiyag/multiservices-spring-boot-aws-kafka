package com.example.bookingservice.query.service;

import com.example.bookingservice.query.model.BookingResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingQueryService {


    public BookingResponse getBookingById(String bookingId) ;

    public List<BookingResponse> getAllBookings();


}
