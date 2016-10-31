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
}
