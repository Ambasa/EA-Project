package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="Person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    @Column(unique=true)
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private Role role;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    public Person(String firstName, String lastName, String emailAddress, String username, String password, LocalDate dateOfBirth, Role role, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.role = role;

        this.address = address;
    }
    //    private String person_type;
}
