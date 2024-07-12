package OOP_Task1.university.controller;

import java.util.ArrayList;
import java.util.List;

import OOP_Task1.university.ecxeptions.NotNullTeacherExpected;
import OOP_Task1.university.model.impl.Student;
import OOP_Task1.university.model.impl.StudyGroup;
import OOP_Task1.university.model.impl.Teacher;
import OOP_Task1.university.service.StudyGroupService;

public class StudyGroupController {

    public List<StudyGroup<Teacher, Student>> studyGroups;
    public StudyGroupService service;

    public StudyGroupController(StudyGroupService service) {
        this.service = service;
        this.studyGroups = new ArrayList<>();
    }

    public StudyGroup<Teacher, Student> createGroup(Teacher teacher, List<Student> students){

        try {

            if(!service.serviceS.getAllStudents().containsAll(students)){
                service.serviceS.addStudents(students);
            }
            StudyGroup<Teacher, Student> group = service.createGroup(teacher, students);
            studyGroups.add(group);
            group.setGroupID(studyGroups.size());
            service.serviceT.getTeacher(teacher).setGroupId(group.getGroupID());
            for (Student student : students) {
                student.setGroupID(group.getGroupID());
            }
            return group;
        } catch (NotNullTeacherExpected e) {
            e.getMessage();
        }
        return null;
    }

    public void addStudyGroup(StudyGroup<Teacher, Student> studyGroup){
        this.studyGroups.add(studyGroup);
    }

    public List<StudyGroup<Teacher, Student>> getStudyGroupsController() {
        return studyGroups;
    }

    public StudyGroup<Teacher, Student> getGroupByGroupId(int groupId){
        return studyGroups.get(groupId - 1);
    }
    
}
