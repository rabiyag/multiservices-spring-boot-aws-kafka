package com.example.bookingservice.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.example.bookingservice.config")
public class BookingEventProducer {

    private static final String BOOKING_TOPIC = "test"; // Kafka topic name

    @Autowired
    private KafkaTemplate<String, BookingEvent> kafkaTemplate;

    public void sendBookingEvent(BookingEvent booking) {
        // Send the booking event to the Kafka topic
        kafkaTemplate.send(BOOKING_TOPIC, booking.getBookingId().toString(), booking);
        System.out.println("Booking event sent: " + booking);
    }
}