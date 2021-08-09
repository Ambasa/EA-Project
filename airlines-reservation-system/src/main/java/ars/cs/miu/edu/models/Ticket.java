package ars.cs.miu.edu.models;

import lombok.*;

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
public class Ticket {
    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @Size(min=20, max = 20)
    private Integer flightNumber;

    @NonNull
    @Size(min = 6, max = 6)
    private String reservationCode;

    @NonNull @NotEmpty
    @Future
    private LocalDate flightDate;

    @NonNull @NotEmpty
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Flight flight;
}
