package org.gb.homework.schooldata.service;

import org.gb.homework.schooldata.model.User;

import java.util.List;

public interface UserService<T extends User> {
    void add(T user);

    void remove(T user);

    void edit(T user);

    List<T> getAllUsers();
}
