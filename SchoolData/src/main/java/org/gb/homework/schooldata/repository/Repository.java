package org.gb.homework.schooldata.repository;

import org.gb.homework.schooldata.model.User;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Repository<T extends User> {
    private final String fileDb;
    private Map<Integer, T> users = new HashMap<>();

    public Repository(String fileDb) {
        this.fileDb = fileDb;
    }

    public void remove(T user) {
        users.remove(user);
    }

    public void edit(T user) {
        users.put(user.getId(), user);
    }

    public void save(T user) {
        users.put(user.getId(), user);
    }

    public List<T> getAll() {
        return new ArrayList<>(users.values());
    }

    public void fetch() {
        try (FileWriter fileWriter = new FileWriter(fileDb)) {
            for (var u : users.values()) {
                fileWriter.write(u.toString());
                fileWriter.flush();
            }
        } catch (Exception exception) {
        }
    }

    public void commit() {
        try (FileWriter fileWriter = new FileWriter(fileDb)) {
            for (var u : users.values()) {
                fileWriter.write(u.toString());
                fileWriter.flush();
            }
        } catch (Exception exception) {
        }
    }
}
