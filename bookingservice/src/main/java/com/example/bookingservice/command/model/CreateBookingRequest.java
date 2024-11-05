package com.example.bookingservice.command.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateBookingRequest {

    @NotBlank(message = "User ID is required")
    private String userId;

    @NotBlank(message = "Travel details are required")
    @Size(max = 500, message = "Travel details must be less than 500 characters")
    private String travelDetails;

    @NotNull(message = "Travel date is required")
    private String travelDate;  // Could use a more specific date type, depending on requirements

    public CreateBookingRequest() {
    }

    public CreateBookingRequest(String userId, String travelDetails, String travelDate) {
        this.userId = userId;
        this.travelDetails = travelDetails;
        this.travelDate = travelDate;
    }

    // Getters and Setters
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

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    @Override
    public String toString() {
        return "CreateBookingRequest{" +
                "userId='" + userId + '\'' +
                ", travelDetails='" + travelDetails + '\'' +
                ", travelDate='" + travelDate + '\'' +
                '}';
    }
}
