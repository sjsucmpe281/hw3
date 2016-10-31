package com.cmpe281.hw3.models;

import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.*;

/**
 * Harish Kumar K V
 */
@XmlRootElement(name="employees-list")
public class EmployeeList implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Employee> employees;

    public EmployeeList () {
        super();
        employees = new ArrayList<> ();
    }

    @XmlElement(name="employee")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees)  {
        this.employees = employees;
    }
}
