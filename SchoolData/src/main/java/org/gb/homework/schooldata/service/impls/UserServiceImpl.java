package org.gb.homework.schooldata.service.impls;

import org.gb.homework.schooldata.model.User;
import org.gb.homework.schooldata.repository.Repository;
import org.gb.homework.schooldata.service.UserService;

import java.util.List;

/**
 *
 */
public class UserServiceImpl<T extends User> implements UserService<T> {
    protected final Repository<T> repository;

    public UserServiceImpl(Repository<T> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> getAllUsers() {
        return repository.getAll();
    }

    @Override
    public void add(T user) {
        repository.save(user);

    }

    @Override
    public void remove(T user) {
        repository.remove(user);
    }

    @Override
    public void edit(T user) {
        repository.save(user);
    }
}
