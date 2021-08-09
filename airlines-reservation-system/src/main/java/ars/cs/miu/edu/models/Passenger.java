package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="Passenger")
public class Passenger extends Person{
    @OneToMany
    @JoinColumn(name="passenger_id")
    private List<Reservation> reservations;
//    public Passenger(String firstName, String lastName, String emailAddress, String username, String password, LocalDate dob, Role passenger, Address address) {
//        super(firstName,lastName,emailAddress,username,password,dob,passenger,address);
//    }
}
