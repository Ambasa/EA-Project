package ars.cs.miu.edu.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin extends Person{

}
