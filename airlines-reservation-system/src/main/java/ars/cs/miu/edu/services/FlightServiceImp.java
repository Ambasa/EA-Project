package ars.cs.miu.edu.services;

import ars.cs.miu.edu.models.Flight;
import ars.cs.miu.edu.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImp implements FlightService{
    @Autowired
    FlightRepository flightRepository;

    @Override
    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }
}
