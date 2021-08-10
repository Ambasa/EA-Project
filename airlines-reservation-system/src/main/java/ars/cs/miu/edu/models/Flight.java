package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
    @NotBlank(message = "Flight number is mandatory")
    @Size(min=20, max=20)
    private int flightNumber;
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Enter natural numbers")
    private int capacity;
    @ManyToOne(cascade = CascadeType.ALL)
    private Airport arrivalAirport;
    @ManyToOne(cascade = CascadeType.ALL)
    private Airport departureAirport;
    @ManyToOne(cascade = CascadeType.ALL)
    private Airline airline;

}
