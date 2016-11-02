package com.cmpe281.hw3.controllers;

import com.cmpe281.hw3.models.*;
import com.cmpe281.hw3.service.ProjectService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping( "cmpe281harishkumarkv013/rest" )
public class ProjectController {

    private ProjectService projectService;

    @PostConstruct
    public void init()  {
        System.out.println("Inside Init Method");
        projectService = new ProjectService ();
    }

    @RequestMapping(
            value = "/project",
            method = RequestMethod.GET,
            headers = "Accept=*/*",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<ProjectList> getAllProjects()   {
        System.out.println("Fetching");
        return ResponseEntity.status(HttpStatus.OK).body(projectService.fetchAll());
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
    public ResponseEntity<Project> getProject(@PathVariable(value="id") Integer id)   {
        System.out.println("ID = " + id);
        return ResponseEntity.status(HttpStatus.OK).body(projectService.fetch(id));
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
    public void createProject(@RequestBody Project project)    {
        projectService.insert(project);
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
