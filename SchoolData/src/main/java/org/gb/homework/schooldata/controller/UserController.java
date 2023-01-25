package org.gb.homework.schooldata.controller;

import org.gb.homework.schooldata.model.User;
import org.gb.homework.schooldata.service.UserService;

//Контроллер
public class UserController<T extends User> {
    private UserService<T> service;

    public UserController(UserService<T> service) {
        this.service = service;
    }

    public void getStudentInfo(String name, float grade, int year) {
        //service.add(new Student(name, grade, year));

    }
}
