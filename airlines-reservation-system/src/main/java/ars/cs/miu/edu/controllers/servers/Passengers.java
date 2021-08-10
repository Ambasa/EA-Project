package ars.cs.miu.edu.controllers.servers;

import ars.cs.miu.edu.models.Reservation;
import ars.cs.miu.edu.services.AirlinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.Valid;

@RestControllerAdvice
@ControllerAdvice
@RequestMapping("/ars")
public class Passengers {
    @Autowired
    private AirlinesService<Reservation> reservationAirlinesService;

    /* View list of airports
    o View list of airlines flying out of an airport (search by airport three letter code)
o View list of flights between a departure and destination for a date
o View list of own reservations
o View details of a reservation (flights, departure times, etc.)
o Make a reservation (note: payload will be a list of flights)
o Cancel a reservation
o Confirm and purchase a reservation. This will result in multiple tickets (one for each
flight in the reservation) */

      // Make a reservation (note: payload will be a list of flights)
    public ResponseEntity<?> makeReservation(@RequestBody @Valid Reservation reservation){
        reservationAirlinesService.add(reservation);

        return ResponseEntity.ok(reservation);

    }





}
