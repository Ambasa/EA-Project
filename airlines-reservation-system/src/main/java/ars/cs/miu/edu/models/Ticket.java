package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotNull
    @Size(min=6, max=6)
    private String reservationCode;
    @Future
    private LocalDate flightDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Flight flight;
}
