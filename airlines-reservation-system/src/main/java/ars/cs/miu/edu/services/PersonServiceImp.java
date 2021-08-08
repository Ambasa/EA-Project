package ars.cs.miu.edu.services;

import ars.cs.miu.edu.models.Passenger;
import ars.cs.miu.edu.models.Person;
import ars.cs.miu.edu.repository.PassengerRepository;
import ars.cs.miu.edu.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonService {
    @Autowired
    PassengerRepository passangerRepository;
    @Autowired
    PersonRepository personRepository;
    @Override
    public void createPassanger(Person p) {
        personRepository.save(p);
    }
//
//    View list of airports
//    o View list of airlines flying out of an airport (search by airport three letter code)
//    o View list of flights between a departure and destination for a date
//    o View list of own reservations
//    o View details of a reservation (flights, departure times, etc.)
//    o Make a reservation (note: payload will be a list of flights)
//    o Cancel a reservation
//    o Confirm and purchase a reservation.


}
