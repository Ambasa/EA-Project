package ars.cs.miu.edu.models;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value = "Admin")
public class Admin extends Person{

}
