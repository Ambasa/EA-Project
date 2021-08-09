package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
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

    @NonNull
    @Size(min = 3, max = 3)
    private String code;

    @NonNull @NotEmpty
    @Max(50)
    private String name;

    @NonNull @NotEmpty
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Address address;
}
