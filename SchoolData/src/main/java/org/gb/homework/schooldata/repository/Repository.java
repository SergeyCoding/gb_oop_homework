package org.gb.homework.schooldata.repository;

import org.gb.homework.schooldata.model.User;

public class Repository<T extends User> {
    private final String fileDb;

    public Repository(String fileDb) {

        this.fileDb = fileDb;
    }

    public void remove(T user) {
    }

    public void edit(T user) {
    }
}
