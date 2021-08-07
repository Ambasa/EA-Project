package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private long id;
    private String reservationCode;
    private LocalDate flightDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Flight flight;
}
