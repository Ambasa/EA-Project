package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Airline")
@SecondaryTable(name = "History")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull @NotEmpty 
    @Size(min=2, max=2)
    private String code;
    @NonNull
    private String name;
    @Column(table = "History")
    @Size(min=2, max=2000)
    private String history;
}
