package org.gb.homework.schooldata.repository;

import org.gb.homework.schooldata.model.User;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 */
public class Repository<T extends User> {
    private final String fileDb;

    private Dictionary<Integer, T> users = new Hashtable<>();

    public Repository(String fileDb) {
        this.fileDb = fileDb;
    }

    public void remove(T user) {
        users.remove(user);
    }

    public void edit(int id, T user) {
        users.put(id, user);
    }
}
