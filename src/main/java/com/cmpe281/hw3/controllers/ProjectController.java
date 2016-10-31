package com.cmpe281.hw3.controllers;

import com.cmpe281.hw3.models.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping( "cmpe281harishkumarkv013/rest" )
public class ProjectController {

    @RequestMapping(
            value = "/project",
            method = RequestMethod.GET,
            headers = "Accept=*/*",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ProjectList getAllProjects()   {
        ProjectList projects = new ProjectList ();
        projects.getProjects ().add (new Project (1, "Harishkumar", 1000F));
        projects.getProjects ().add (new Project (2, "Harishkumar", 1000F));
        projects.getProjects ().add (new Project (3, "Harishkumar", 1000F));
        return projects;
    }

    @RequestMapping(
            value = "/project/{id}",
            method = RequestMethod.GET,
            headers = "Accept=*/*",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public Project getProject(@PathVariable(value="id") Integer id)   {
        System.out.println("ID = " + id);
        return new Project (1, "Harishkumar", 1000F);
    }

    @RequestMapping(
            value = "/project",
            method = RequestMethod.POST,
            headers = "Accept=*/*",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public void createProject(@PathVariable(value="id") Integer id,
                               @RequestBody Project project)    {
        System.out.println(project.getId ());
        System.out.println(project.getName ());
        System.out.println(project.getBudget ());
    }

    @RequestMapping(
            value = "/project/{id}",
            method = RequestMethod.PUT,
            headers = "Accept=*/*",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public void updateProject(@PathVariable(value="id") Integer id,
                               @RequestBody Project project)    {
        System.out.println(project.getId ());
        System.out.println(project.getName ());
        System.out.println(project.getBudget ());
    }

    @RequestMapping(
            value = "/project/{id}",
            method = RequestMethod.DELETE,
            headers = "Accept=*/*",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    public void deleteProject(@PathVariable(value="id") Integer id)    {
        System.out.println("ID = " + id);
    }
}
