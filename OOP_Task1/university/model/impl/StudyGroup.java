package OOP_Task1.university.model.impl;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("hiding") // понятия не имею что это значит, но студия говорит что так надо сделать
public class StudyGroup<Teacher, Student>{
    
    private Teacher teacher;
    private List<Student> students;
    private int groupID;

    public StudyGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    public StudyGroup() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public void setStudent(Student student){
        this.students.add(student);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
}
