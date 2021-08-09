package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=6, max=6)
    private String reservationCode;
    @NotNull
    @Size(min=2, max=30)
    private String departure;
    @NotNull
    @Size(min=2, max=30)
    private String destination;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "reservationCode")
    private List<Ticket> tickets;
    private Status status;

}
