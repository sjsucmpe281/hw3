package com.cmpe281.hw3.service;

import com.cmpe281.hw3.models.*;
import com.google.cloud.datastore.*;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.GqlQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.Query.*;
import com.google.datastore.v1.*;
import com.google.datastore.v1.RunQueryRequest.*;

/**
 * Harish Kumar K V
 */
public class EmployeeService {

    private final KeyFactory keyFactory;

    private static final String KIND = "Employee";

    public EmployeeService()    {
        keyFactory = DataBaseService.getKeyFactory (Employee.class);
    }

    public void add (Employee employee) {
        String entry = validate(employee);
        /*if(entry != null)  {
            entry + " cannot be empty";
        }*/
        Key key = keyFactory.newKey (employee.getId ());
        Entity entity = Entity.newBuilder (key)
                .set("id", employee.getId ())
                .set("firstName", employee.getFirstName ())
                .set("lastName", employee.getLastName ())
                .build();
        Entity ent = null;
        try{
            ent = DataBaseService.getDateStore ().add (entity);
        }catch(Exception e) {
            System.out.println(e.getMessage ());
        }
        System.out.println("Entity " + ent);
//        return "Created";
    }

    public Employee get(Integer id)   {
        Key key = keyFactory.newKey (id);
        Entity entity = DataBaseService.getDateStore ().get (key);
        Employee employee =
                new Employee ((int)entity.getLong ("id"), entity.getString ("firstName"),
                        entity.getString ("lastName"));
        System.out.println(employee.getId ());
        System.out.println(employee.getFirstName ());
        System.out.println(employee.getLastName ());
        return employee;
    }

    public EmployeeList getAll()    {
        Query<Entity> query = Query.newGqlQueryBuilder (Query.ResultType.ENTITY, "select * from " + KIND).build();
        QueryResults<Entity> results = DataBaseService.getDateStore ().run(query);
        EmployeeList employees = new EmployeeList ();
        while(results.hasNext ())   {
            Entity entity = results.next ();
            employees.getEmployees ().add (new Employee ((int)entity.getLong ("id"), entity.getString ("firstName"),
                    entity.getString ("lastName")));
        }
        return employees;
    }

    public void update (Integer id, Employee employee)  {
        Key key = keyFactory.newKey (id);
        Entity entity = DataBaseService.getDateStore ().get (key);
        if(entity == null)  {
            add (employee);
            return;
        }
        entity = Entity.newBuilder (key)
                .set("id", id)
                .set("firstName", employee.getFirstName ())
                .set("lastName", employee.getLastName ())
                .build();
        DataBaseService.getDateStore ().put (entity);
    }

    public void delete(Integer id)    {
        Key key = keyFactory.newKey (id);
        DataBaseService.getDateStore ().delete (key);
    }

    private String validate (Employee employee) {
        if(employee.getId () == null)   {
            return "Id";
        }
        if(employee.getFirstName () == null)    {
            return "FirstName";
        }
        if(employee.getLastName () == null) {
            return "LastName";
        }
        return null;
    }
}
