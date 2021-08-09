package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Address {
    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @Size(min = 2, max = 30)
    private String street;

    @NonNull
    @Size(min = 2, max = 20)
    private String city;

    @NonNull
    @Size(min = 2, max = 20)
    private String state;

    @NonNull @NotEmpty
    @Size(min = 2, max = 10)
    private String zip;
}
