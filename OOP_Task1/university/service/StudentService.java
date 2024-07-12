package OOP_Task1.university.service;

import OOP_Task1.university.model.impl.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    List<Student> students = new ArrayList<>();// список всех студентов.

    public Student createStudent(String name, String lastName){
        return new Student(name, lastName);
    }

    public Student getById(int id){ // дописать свое исключение
        return students // список студентов
                        .stream() // запускаем поток для вычислений
                        .filter(student -> student.getId() == id) // фильтр по которому будет происходить поиск.
                        .findFirst() // возвращает студента, если есть совпадения
                        .orElse(null); // если никто не найден, то вернуть null
    }

    public List<Student> getAllStudents(){
        return this.students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addStudents(List<Student> students){
        this.students.addAll(students);
    }

}
