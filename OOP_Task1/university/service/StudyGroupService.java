package OOP_Task1.university.service;

import java.util.List;

import OOP_Task1.university.ecxeptions.NotNullTeacherExpected;
import OOP_Task1.university.model.impl.Student;
import OOP_Task1.university.model.impl.StudyGroup;
import OOP_Task1.university.model.impl.Teacher;

public class StudyGroupService{

    public StudyGroup<Teacher, Student> studyGroup;
    public TeacherService serviceT;
    public StudentService serviceS;

    public StudyGroupService(TeacherService serviceT, StudentService serviceS) {
        this.serviceT = serviceT;
        this.serviceS = serviceS;
    }

    public StudyGroupService() {
    }

    public StudyGroup<Teacher, Student> createGroup(Teacher teacher, List<Student> students)
                    throws NotNullTeacherExpected    
    {
        if(teacher != null){
            if(!serviceT.getAllTeachers().contains(teacher)){
                serviceT.addTeacher(teacher);
            }
            studyGroup = new StudyGroup<Teacher, Student>(teacher, students);
            return studyGroup;
        }else{
            throw new NotNullTeacherExpected("Учитель является null объектом.");
        }
    }

    public void setStudents(List<Student> students) {
        studyGroup.setStudents(students);
    }

    public void setStudents(Student students) {
        studyGroup.setStudent(students);
    }

    public void setTeacher(Teacher teacher) {
        studyGroup.setTeacher(teacher);
    }

    public List<Student> getStudents() {
        return studyGroup.getStudents();
    }

    public Teacher getTeacher() {
        return studyGroup.getTeacher();
    }

    public void printGroup(StudyGroup<Teacher, Student> studyGroup){

        if(studyGroup.getTeacher() != null){
            System.out.println(studyGroup.getTeacher());
        }else{
            try {
                throw new NotNullTeacherExpected("Группы нет, потому что учитель является null.");
            } catch (NotNullTeacherExpected e) {
                e.getMessage();
            }
        }

        for (Student student : studyGroup.getStudents()) {
            System.out.println(student);
        }
    }

    public Integer getGroupID(){
        if(studyGroup != null){
            return studyGroup.getGroupID();
        }else{
            return null;
        }
    }


}
