package com.cmpe281.hw3.models;

import javax.xml.bind.annotation.*;
import java.io.*;

/**
 * Harish Kumar K V
 */
@XmlRootElement(name = "project")
public class Project implements Serializable {

    private static final long serialVersionUID = 4L;

    private Integer id;
    private String name;
    private Float budget;

    public Project()    {}

    public Project(Integer id, String name, Float budget) {
        this.id = id;
        this.name = name;
        this.budget = budget;
    }

    public Integer getId()  {
        return id;
    }

    public void setId(Integer id)   {
        this.id = id;
    }

    public String getName()   {
        return name;
    }

    public void setName(String name)   {
        this.name = name;
    }

    public Float getBudget () {
        return budget;
    }

    public void setBudget (Float budget) {
        this.budget = budget;
    }
}
