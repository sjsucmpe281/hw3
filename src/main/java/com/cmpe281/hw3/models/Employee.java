package com.cmpe281.hw3.models;

import javax.xml.bind.annotation.*;
import java.io.*;

/**
 * Harish Kumar K V
 */
@XmlRootElement(name="employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 2L;

    private Integer id;

    private String firstName;

    private String lastName;

    public Employee ()  {}

    public Employee (Integer id, String firstName, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
}
