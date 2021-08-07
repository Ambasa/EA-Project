package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity

public class Reservation {
    @Id
    @GeneratedValue
    private long id;
    private String reservationCode;
    private String departure;
    private String destination;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    private Status status;

}
