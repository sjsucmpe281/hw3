package com.cmpe281.hw3.controllers;

import com.cmpe281.hw3.models.*;
import com.cmpe281.hw3.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;

@RestController
@RequestMapping({ "cmpe281harishkumarkv013/rest" })
public class EmployeeController {

    private EmployeeService employeeService;

    @PostConstruct
    public void init()  {
        System.out.println("Inside Init Method");
        employeeService = new EmployeeService ();
    }

    @RequestMapping(
            value = "/employee",
            method = RequestMethod.GET,
            headers = "Accept=*/*",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public EmployeeList getAllEmployees()   {
        return employeeService.getAll ();
    }

    @RequestMapping(
            value = "/employee/{id}",
            method = RequestMethod.GET,
            headers = "Accept=*/*",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public Employee getEmployee(@PathVariable(value="id") Integer id)   {
        System.out.println("ID = " + id);
        return employeeService.get (id);
    }

    @RequestMapping(
            value = "/employee",
            method = RequestMethod.POST,
            headers = "Accept=*/*",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)    {
        System.out.println(employee.getId ());
        System.out.println(employee.getFirstName ());
        System.out.println(employee.getLastName ());
        employeeService.add (employee);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @RequestMapping(
            value = "/employee/{id}",
            method = RequestMethod.PUT,
            headers = "Accept=*/*",
            consumes = {
                MediaType.APPLICATION_XML_VALUE,
                MediaType.APPLICATION_JSON_VALUE
            }
    )
    public void updateEmployee(@PathVariable(value="id") Integer id,
                               @RequestBody Employee employee)    {
        System.out.println(employee.getId ());
        System.out.println(employee.getFirstName ());
        System.out.println(employee.getLastName ());
        employeeService.update (id, employee);
    }

    @RequestMapping(
            value = "/employee/{id}",
            method = RequestMethod.DELETE,
            headers = "Accept=*/*",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    public void deleteEmployee(@PathVariable(value="id") Integer id)    {
        System.out.println("ID = " + id);
        employeeService.delete (id);
    }
}
