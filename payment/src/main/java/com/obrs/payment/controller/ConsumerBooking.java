package com.obrs.payment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.obrs.payment.model.Booking;
import com.obrs.payment.model.Payment;
import com.obrs.payment.repository.BookingRepository;
import com.obrs.payment.repository.PaymentRepository;

import io.micrometer.core.instrument.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class ConsumerBooking
{
    private final Logger logger = LoggerFactory.getLogger(ConsumerBooking.class);

    @Qualifier("analyticsDataCounter")
    @Autowired
    Counter analytics_counter;

    @Qualifier("offerCounter")
    @Autowired
    Counter offer_counter;
    @Autowired
    PaymentRepository repo;
    @Autowired
    BookingRepository bookingRepository;
    
    @KafkaListener(topics = "event-queue", groupId = "group_id")
    public void consume(String message) throws IOException
    {

        analytics_counter.increment();

        ObjectMapper mapper  = new ObjectMapper();

         EventQueueDatum datum =  mapper.readValue(message,EventQueueDatum.class);

         switch (datum.getType())
         {
           //  case "PAYMENTINITIATE"   : logger.info(String.format("#### -> Consumed message -> %s", datum.getMessage()));break;
             case "PAYMENTINITIATE"   : logger.info( datum.getMessage()+" ---> "+mapper.readValue(datum.getPayload(), Payment.class));
               Payment createPayment=mapper.readValue(datum.getPayload(), Payment.class);
               repo.save(createPayment);
               Optional<Booking> booking=bookingRepository.findById(createPayment.getBookingno());
               booking.get().setStatus("Confirmed");
               bookingRepository.save(booking.get());
             break;
             
             default: logger.info(message);
         }
    }
}