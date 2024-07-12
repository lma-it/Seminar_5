package OOP_Task1.university.service;

import java.util.ArrayList;
import java.util.List;

import OOP_Task1.university.model.impl.Teacher;

public class TeacherService {

    private List<Teacher> teachers = new ArrayList<>();
    
    public Teacher createTeacher(String name, String lastName){
        return new Teacher(name, lastName);
    }

    public Teacher getById(int id){ // дописать свое исключение
        return teachers // список учителей
                        .stream() // запускаем поток для вычислений
                        .filter(teacher -> teacher.getId() == id) // фильтр по которому будет происходить поиск.
                        .findFirst() // возвращает учителя, если есть совпадения
                        .orElse(null); // если никто не найден, то вернуть null
    }

    public Teacher getTeacher(Teacher teacher){
        int index = this.teachers.indexOf(teacher);
        return this.teachers.get(index);
    }

    public List<Teacher> getAllTeachers(){
        return this.teachers;
    }

    public void addTeacher(Teacher teacher){
        this.teachers.add(teacher);
    }
}
