package com.example.bookingservice.query.model;

import com.example.bookingservice.command.model.BookingCommand.BookingStatus;

import java.time.LocalDateTime;

public class BookingResponse {

    private Long bookingId;
    private String userId;
    private String travelDetails;
    private LocalDateTime bookingDate;
    private BookingStatus status;

    public BookingResponse() {
    }

    public BookingResponse(Long bookingId, String userId, String travelDetails, LocalDateTime bookingDate, BookingStatus status) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.travelDetails = travelDetails;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTravelDetails() {
        return travelDetails;
    }

    public void setTravelDetails(String travelDetails) {
        this.travelDetails = travelDetails;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingResponse{" +
                "bookingId='" + bookingId + '\'' +
                ", userId='" + userId + '\'' +
                ", travelDetails='" + travelDetails + '\'' +
                ", bookingDate=" + bookingDate +
                ", status=" + status +
                '}';
    }
}
