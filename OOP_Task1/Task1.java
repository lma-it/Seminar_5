package OOP_Task1;

import OOP_Task1.university.controller.StudyGroupController;
import OOP_Task1.university.service.StudentService;
import OOP_Task1.university.service.StudyGroupService;
import OOP_Task1.university.service.TeacherService;
import OOP_Task1.university.view.StudyGroupsView;

/**
 * Task1
 */
public class Task1 {

    public static void main(String[] args) {
        new StudyGroupsView(new StudyGroupController(new StudyGroupService(new TeacherService(), new StudentService()))).start();
    }
}