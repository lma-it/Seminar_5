package OOP_Task1.university.controller;

import OOP_Task1.university.service.StudentService;

public class StudentController {
    protected StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    public StudentService getService() {
        return service;
    }
}
