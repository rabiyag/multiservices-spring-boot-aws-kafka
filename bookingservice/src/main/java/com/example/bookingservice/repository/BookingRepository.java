package com.example.bookingservice.repository;

import com.example.bookingservice.command.model.BookingCommand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingCommand, String> {
    List<BookingCommand> findByUserId(String userId);
}
