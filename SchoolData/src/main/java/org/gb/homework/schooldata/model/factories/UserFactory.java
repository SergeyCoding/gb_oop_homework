package org.gb.homework.schooldata.model.factories;

import org.gb.homework.schooldata.model.User;

public interface UserFactory<T extends User> {

    T deserialize(String line);
}

