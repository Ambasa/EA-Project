package ars.cs.miu.edu;

import ars.cs.miu.edu.models.Address;
import ars.cs.miu.edu.models.Passenger;
import ars.cs.miu.edu.models.Person;
import ars.cs.miu.edu.models.Role;
import ars.cs.miu.edu.repository.PassengerRepository;
import ars.cs.miu.edu.services.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        PersonService personService = context.getBean(PersonService.class);
        Address address = new Address("fairfield", "IOWA" ,"USA", 52557);
        LocalDate dob = LocalDate.of(1997,02,12);
        Person person = new Passenger("firstName", "lastName", "emailAddress", "username", "password", dob, Role.PASSENGER,  address);
        Passenger passenger = new Passenger();
        passenger.setFirstName("Km Hira");
        passenger.setLastName("Kafle");
        personService.createPassanger(passenger);
        personService.createPassanger(person);

    }

}
