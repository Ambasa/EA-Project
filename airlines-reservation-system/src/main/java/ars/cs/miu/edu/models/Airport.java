package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Airport {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @Size(min=3, max=3)
    private String code;
    @NotNull
    @Size(min=2, max=60)
    private String name;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Address address;
}
