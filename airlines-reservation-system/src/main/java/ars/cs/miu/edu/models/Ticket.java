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
@Table(name="Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reservationCode;
    private LocalDate flightDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Flight flight;
}
