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
    private static final boolean isCommitEverytime = false;
    private final String fileDb;
    private final Map<Integer, T> users = new HashMap<>();
    private boolean isFetch = true;

    public Repository(String fileDb) {
        this.fileDb = fileDb;
    }

    public void remove(T user) {
        fetch();
        users.remove(user.getId());
        commit();
    }

    public void edit(T user) {
        save(user);
    }

    public void save(T user) {
        fetch();
        users.put(user.getId(), user);
        commit();
    }

    public List<T> getAll() {
        fetch();
        return new ArrayList<>(users.values());
    }

    public void fetch() {
        if (isFetch)
            return;

        try (FileWriter fileWriter = new FileWriter(fileDb)) {
            for (var u : users.values()) {
                fileWriter.write(u.toString());
                fileWriter.flush();
            }
        } catch (Exception ignored) {
        }

        isFetch = true;
    }

    public void commit() {
        if (!isCommitEverytime)
            return;

        try (FileWriter fileWriter = new FileWriter(fileDb)) {
            for (var u : users.values()) {
                fileWriter.write(u.toString());
                fileWriter.flush();
            }
        } catch (Exception exception) {
        }
    }
}
