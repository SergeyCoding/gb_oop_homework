package org.gb.homework.schooldata.service;

import org.gb.homework.schooldata.model.Teacher;

public interface TeacherService {
    void add(Teacher teacher);

    void remove(Teacher teacher);

    void edit(String name);

}
