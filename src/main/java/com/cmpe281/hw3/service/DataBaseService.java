package com.cmpe281.hw3.service;

import com.google.cloud.datastore.*;

import java.util.concurrent.atomic.*;

/**
 * Harish Kumar K V
 */
public class DataBaseService {
    private static AtomicReference<Datastore> datastore = new AtomicReference<> ();

    public static Datastore getDateStore () {
        if (datastore.get () == null) {
            System.out.println("Creating data store instance");
            datastore.set (DatastoreOptions.newBuilder ().setProjectId ("spring-boot-test-147106").build ().getService ());
            System.out.println("Instance created " + datastore.get ());
        }

        return datastore.get ();
    }

    public static KeyFactory getKeyFactory (Class<?> c) {
        return getDateStore ().newKeyFactory ().setKind (c.getSimpleName ());
    }
}
