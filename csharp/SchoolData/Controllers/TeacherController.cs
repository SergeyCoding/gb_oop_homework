﻿using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Service;
using Gb.Homework.SchoolData.View;

namespace Gb.Homework.SchoolData.Controllers
{


    public class TeacherController
    {
        private readonly UserService<Teacher> teacherService;
        private readonly TeacherView view;
        public Teacher currentTeacher;

        public TeacherController(UserService<Teacher> service, TeacherView view)
        {
            this.teacherService = service;
            this.view = view;
        }


        public void printAll()
        {
            var users = teacherService.getAllUsers();
            view.showAll(users);
        }

        public void run()
        {
            var isWorking = true;

            while (isWorking)
            {

                var numberTask = view.showMenu(currentTeacher);

                switch (numberTask)
                {
                    case 0->isWorking = false;
                    case 1->printAll();
                    case 2->chooseTeacher();
                    case 3->addTeacher();
                    case 4->editTeacher();
                    case 5->deleteTeacher();
                    default -> view.showTaskError();
                }
            }

        }


        private void deleteTeacher()
        {
            if (currentTeacher == null)
            {
                view.showCurrentTeacherError();
                return;
            }
            teacherService.remove(currentTeacher);
            currentTeacher = null;
        }

        private void editTeacher()
        {
            if (currentTeacher == null)
            {
                view.showCurrentTeacherError();
                return;
            }

            var name = view.inputName();
            currentTeacher.setName(name);
            teacherService.edit(currentTeacher);
        }

        private void addTeacher()
        {
            var name = view.inputName();

            Optional<Teacher> lastTeacher = teacherService.getAllUsers().stream().max(Comparator.comparingInt(User::getId));

            var nextId = 0;

            if (lastTeacher.isPresent())
                nextId = lastTeacher.get().getId() + 1;

            teacherService.add(new Teacher(nextId, name));
        }

        private void chooseTeacher()
        {
            var nextId = teacherService.getNextId();
            var teacherId = view.getTeacherId(nextId);

            currentTeacher = teacherService.getAllUsers().stream().filter(x->x.getId() == teacherId)
                    .findFirst().orElse(null);
        }
    }

}
