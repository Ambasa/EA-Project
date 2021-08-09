package ars.cs.miu.edu.models;

import lombok.*;
import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Flight {
    @Id
    @GeneratedValue
    private long id;

    private int flightNumber;

    @NonNull
    @Size(min = 3, max = 100)
    private int capacity;

    @NonNull @NotEmpty
    @Future
    private LocalDate departureTime;

    @NonNull @NotEmpty
    @Future
    private LocalDate arrivalTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airport arrivalAirport;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airport departureAirport;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airline airline;

}
