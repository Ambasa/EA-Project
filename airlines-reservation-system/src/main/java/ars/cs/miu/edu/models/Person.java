package ars.cs.miu.edu.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=2, max=20)
    private String firstName;
    @NotNull
    @Size(min=2, max=20)
    private String lastName;
    @NotNull
    @Email
    private String emailAddress;
    @Column(unique=true)
    private String username;
    @Size(min=6, max=50)
    private String password;
    @Past
    private LocalDate dateOfBirth;
    private Role role;

    public Person(){}

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Address address;
    @Column(insertable=false, updatable=false)
    private String person_type;
}
