package ars.cs.miu.edu.models;

import lombok.*;
import net.bytebuddy.implementation.bytecode.StackSize;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @Size(min = 2, max = 20)
    private String firstName;

    @NonNull
    @Size(min = 2, max = 20)
    private String lastName;

    @NonNull @NotEmpty
    @Email
    private String emailAddress;

    @Column(unique=true)
    @NonNull
    @Size(min = 2, max = 6)
    private String username;

    @NonNull
    @Size(min = 5, max = 20)
    private String password;

    @NonNull @NotEmpty
    @Past
    private LocalDate dateOfBirth;

    private Role role;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Address address;
}
