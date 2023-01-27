package org.gb.homework.schooldata.repository;

import org.gb.homework.schooldata.model.User;
import org.gb.homework.schooldata.model.factories.UserFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Repository<T extends User> {
    private static final boolean isCommitEverytime = true;
    private final String fileDb;
    private final UserFactory<T> userFactory;
    private final Map<Integer, T> users = new HashMap<>();
    private boolean isFetch = false;

    public Repository(String fileDb, UserFactory<T> userFactory) {
        this.fileDb = fileDb;
        this.userFactory = userFactory;
    }

    public void remove(T user) {
        fetch();
        users.get(user.getId()).setActual(false);
        commit();
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

        isFetch = true;

        try {
            Path path = Paths.get(fileDb);
            if (Files.exists(path)) {
                List<String> allLines = Files.readAllLines(path);

                for (String line : allLines) {
                    T user = userFactory.deserialize(line);
                    users.put(user.getId(), user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void commit() {
        if (!isCommitEverytime)
            return;

        try (FileWriter fileWriter = new FileWriter(fileDb)) {
            for (var u : users.values()) {
                fileWriter.write(u.serialize());
                fileWriter.write(System.lineSeparator());
                fileWriter.flush();
            }
        } catch (Exception ignored) {
        }
    }
}
