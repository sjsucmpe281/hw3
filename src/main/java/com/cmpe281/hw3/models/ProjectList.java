package com.cmpe281.hw3.models;

import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.*;

/**
 * Harish Kumar K V
 */
@XmlRootElement(name="projects-list")
public class ProjectList implements Serializable {

    private static final long serialVersionUID = 3L;

    private List<Project> projects;

    public ProjectList()    {
        projects = new ArrayList<> ();
    }

    @XmlElement(name="project")
    public List<Project> getProjects()  {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
