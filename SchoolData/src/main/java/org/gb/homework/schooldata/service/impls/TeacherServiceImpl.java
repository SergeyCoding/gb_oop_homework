package org.gb.homework.schooldata.service.impls;

import org.gb.homework.schooldata.model.Teacher;
import org.gb.homework.schooldata.repository.Repository;

public class TeacherServiceImpl extends UserServiceImpl<Teacher> {


    public TeacherServiceImpl(Repository<Teacher> repository) {
        super(repository);
    }

    @Override
    public void add(Teacher teacher) {
        if (teacher != null) {
            repository.save(teacher);
        }
    }

    @Override
    public void remove(Teacher teacher) {
        if (teacher != null) {
            repository.remove(teacher);
        }
    }

    @Override
    public void edit(Teacher teacher) {
        if (teacher != null) {
            repository.edit(teacher);
        }
    }
}
