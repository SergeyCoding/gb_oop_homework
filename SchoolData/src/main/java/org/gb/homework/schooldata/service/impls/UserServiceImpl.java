package org.gb.homework.schooldata.service.impls;

import org.gb.homework.schooldata.model.User;
import org.gb.homework.schooldata.repository.Repository;
import org.gb.homework.schooldata.service.UserService;

import java.util.List;

/**
 *
 */
public class UserServiceImpl<T extends User> implements UserService<T> {
    private final Repository<T> repository;

    public UserServiceImpl(Repository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void add(T student) {

    }

    @Override
    public void remove(T user) {

    }

    @Override
    public void edit(T user) {

    }

    @Override
    public List<T> getAllUsers() {
        return null;
    }


//    @Override
//    public void add(Student student) {
//        if (student != null) {
//            repository.save(student);
//        } else {
//            System.out.println("Student is null!");
//        }
//    }

//    @Override
//    public void remove(Student student) {
//        if (student != null) {
//            repository.remove(student);
//        }
//    }
//
//    @Override
//    public void edit(Student student) {
//        if (student != null) {
//            repository.edit(student);
//        }
//    }

//    @Override
//    public void add(User student) {
//
//    }
//
//    @Override
//    public void remove(User student) {
//
//    }
//
//    @Override
//    public void edit(User student) {
//
//    }
//
//    @Override
//    public List getAllUsers() {
//        return repository.getAllStudents();
//    }
}
