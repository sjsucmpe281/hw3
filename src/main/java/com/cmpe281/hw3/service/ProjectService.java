package com.cmpe281.hw3.service;

import com.cmpe281.hw3.models.*;
import com.google.cloud.datastore.*;

/**
 * Harish Kumar K V
 */
public class ProjectService {

    private final KeyFactory keyFactory;

    private static final String KIND = "Project";

    public ProjectService()    {
        keyFactory = DataBaseService.getKeyFactory (Project.class);
    }
    
    public void insert(Project project) {
        String entry = validate(project);
        /*if(entry != null)  {
            entry + " cannot be empty";
        }*/
        Key key = keyFactory.newKey (project.getId ());
        Entity entity = Entity.newBuilder (key)
                .set("id", project.getId ())
                .set("name", project.getName ())
                .set("budget", project.getBudget ())
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

    public Project fetch(Integer id)   {
        Key key = keyFactory.newKey (id);
        Entity entity = DataBaseService.getDateStore ().get (key);
        Project project =
                new Project ((int)entity.getLong ("id"), entity.getString ("name"),
                        entity.getString ("budget"));
        System.out.println(project.getId ());
        System.out.println(project.getName ());
        System.out.println(project.getBudget ());
        return project;
    }

    public ProjectList fetchAll()    {
        Query<Entity> query = Query.newGqlQueryBuilder (Query.ResultType.ENTITY, "select * from " + KIND).build();
        QueryResults<Entity> results = DataBaseService.getDateStore ().run(query);
        ProjectList projects = new ProjectList ();
        while(results.hasNext ())   {
            Entity entity = results.next ();
            projects.getProjects ().add (new Project ((int)entity.getLong ("id"), entity.getString ("name"),
                    entity.getString ("budget")));
        }
        return projects;
    }

    public void update (Integer id, Project project)  {
        Key key = keyFactory.newKey (id);
        Entity entity = DataBaseService.getDateStore ().get (key);
        if(entity == null)  {
            insert(project);
            return;
        }
        entity = Entity.newBuilder (key)
                .set("id", id)
                .set("name", project.getName ())
                .set("budget", project.getBudget ())
                .build();
        DataBaseService.getDateStore ().put (entity);
    }

    public void delete(Integer id)    {
        Key key = keyFactory.newKey (id);
        DataBaseService.getDateStore ().delete (key);
    }

    private String validate (Project project) {
        if(project.getId () == null)   {
            return "id";
        }
        if(project.getName () == null)    {
            return "name";
        }
        if(project.getBudget () == null) {
            return "budget";
        }
        return null;
    }    
}
