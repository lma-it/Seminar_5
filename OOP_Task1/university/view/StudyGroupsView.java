package OOP_Task1.university.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import OOP_Task1.university.controller.StudyGroupController;
import OOP_Task1.university.ecxeptions.NotNullTeacherExpected;
import OOP_Task1.university.model.DB.DateBase;
import OOP_Task1.university.model.impl.Student;
import OOP_Task1.university.model.impl.StudyGroup;
import OOP_Task1.university.model.impl.Teacher;


public class StudyGroupsView {
    private StudyGroupController controller;
    private View view;
    DateBase db;
    
    Scanner scan = new Scanner(System.in);

    public StudyGroupsView(StudyGroupController controller) {
        this.controller = controller;
        this.view = new View(this.controller);
        this.db = new DateBase(this.controller);
    }



    public void start(){

        db.fillDB();
        boolean isContinue = true;

        while(isContinue){
            System.out.println("1. Создать новую группу. ");
            System.out.println("2. Просмотреть группы студентов и их преподавателя.");
            System.out.println("3. Показать всех преподавателей.");
            System.out.println("4. Заменить преподавателя в группе по Id группы, и по ID учителя.");
            System.out.println("5. Получить преподавателя группы по ID группы.");
            System.out.println("6. Создать учителя.");
            System.out.println("7. Создать студента.");
            System.out.println("8. Найти студента по id.");
            System.out.println("9. Показать всех студентов.");
            System.out.println("10. Добавить студента по id, в группу по id группы.");
            System.out.println("11. Создать новую группу из свобоного учителя и студентов по их id.");
            System.out.println("0. Выход.");
            String menu = scan.nextLine();

            switch (menu) {
                case "1":
                    StudyGroup<Teacher, Student> group = (controller.createGroup(newTeacher(), createStudents()));
                    viewGroups(group);
                    System.out.println("1. Продолжить.");
                    System.out.println("2. Выход.");
                    switch (scan.nextLine()) {
                        case "2":
                            break;
                    }
                    break;
                case "2":
                    for (StudyGroup<Teacher, Student> studyGroup : controller.getStudyGroupsController()) {
                        viewGroups(studyGroup);
                    }
                    break;
                case "3":
                    System.out.println(controller.service.serviceT.getAllTeachers());
                    break;
                case "4":
                    replaceTeacher();
                    break;
                case "5":
                    System.out.println("Введите id группы, у которой хотите увидеть учителя.");
                    int id = scan.nextInt();
                    System.out.println(getTeacherByGroupID(id));
                    break;
                case "6":
                    controller.service.serviceT.addTeacher(createTeacher());
                    break;
                case "7":
                    controller.service.serviceS.addStudent(view.createStudent());
                    break;
                case "8":
                    System.out.println("Введите id студента, которого хотите найти.");
                    id = scan.nextInt();
                    System.out.println(controller.service.serviceS.getById(id));
                    break;
                case "9":
                    System.out.println(controller.service.serviceS.getAllStudents());
                    break;
                case "10":
                    swapStudent();
                    break;
                case "11":
                    if(!controller.service.serviceS.getAllStudents().isEmpty() && !controller.service.serviceT.getAllTeachers().isEmpty()){
                        createGroupByUsingJustIDs();
                    }else{
                        System.out.println("К сожалению сейчас невозможно создать группу.");
                    }
                    break;
                case "0":
                    System.out.println("Вы хотите продолжить?");
                    System.out.println("1. Да.");
                    System.out.println("2. Нет.");
                    switch (scan.nextLine()) {
                        case "1":
                            menu = "";
                            break;
                        case "2":
                            scan.close();
                            isContinue = false;
                            break;
                    }   
            }
        }
        
    }

    public void createGroupByUsingJustIDs(){

        boolean isCreate = true;
        System.out.println("Список всех учителей, которые не в группах: ");
        for (Teacher teacher : controller.service.serviceT.getAllTeachers()) {
            if(teacher.getGroupID() == null){
                System.out.println(teacher);
            }
        }
        System.out.println("Введите id учителя с которым хотите создать группу.");
        int id = scan.nextInt();
        Teacher tempT = controller.service.serviceT.getById(id);
        List<Student> students = new ArrayList<>();

        while (isCreate) {
            System.out.println("Список всех студентов, которые не в группах: ");
            for (Student student : controller.service.serviceS.getAllStudents()) {
                if(student.getGroupID() == null && !students.contains(student)){
                    System.out.println(student);
                }
            }
            System.out.println("Введите id студента, которого хотите добавить в группу, или 0 для выхода из меню.");
            id = scan.nextInt();
            if(id != 0){
                students.add(controller.service.serviceS.getById(id));
            }else{
                isCreate = false;
            }
        }
        controller.createGroup(tempT, students);
    }

    public void viewGroups(StudyGroup<Teacher, Student> studyGroup){
        controller.service.printGroup(studyGroup);
    }

    public Teacher newTeacher(){
        System.out.println("Введите имя учителя.");
        String name = scan.nextLine();
        System.out.println("Введите фамилию учителя.");
        String lastName = scan.nextLine();
        Teacher teacher = new Teacher(name, lastName);
        return teacher;
    }

    public List<Student> createStudents(){
        List<Student> students = new ArrayList<>();
        boolean isCreate = true;
        
        while(isCreate){
            System.out.println("1. Создать студента для группы.");
            System.out.println("2. Выход");
            String menu = scan.nextLine();
            switch (menu) {
                case "1":
                    students.add(view.createStudent());
                    break;
                case "2":
                    isCreate = false;
                    break;
            }
        }
        return students;
    }

    public void replaceTeacher(){
        
        System.out.println("Список всех преподавателей.");
        for (Teacher teacher : controller.service.serviceT.getAllTeachers()) {
            System.out.println(String.format("%s group: %s", teacher, teacher.getGroupID()));
        }

        System.out.println("Введите ID группы, в которой хотите заменить преподавателя. ");
        int id = scan.nextInt();
        StudyGroup<Teacher, Student> tempG = controller.getGroupByGroupId(id);
        controller.studyGroups.remove(tempG);
        Teacher tempT = tempG.getTeacher();
        tempT.setIsNoGroup(true);
        tempT.setGroupId(null);
        System.out.println("Введите ID учителя, которым хотите заменить учителя в группе.");
        id = scan.nextInt();
        tempT = controller.service.serviceT.getById(id);

        if(tempT != null){
            tempT.setIsNoGroup(false);
            tempT.setGroupId(tempG.getGroupID());
            tempG.setTeacher(tempT);
            controller.studyGroups.add(tempG);
            System.out.println("Преподаватель успешно заменен.");
        }else{
            try {
                throw new NotNullTeacherExpected("Учителя с таким ID не существует, или же он является null.");
            } catch (NotNullTeacherExpected e) {
                e.getMessage();
            }
        }
    }

    public Teacher getTeacherByGroupID(int groupID){
        return controller.getGroupByGroupId(groupID).getTeacher();
    }

    public Teacher createTeacher(){
        System.out.println("Введите имя учителя: ");
        String name = scan.nextLine();
        System.out.println("Введите фамилию учителя: ");
        String lastName = scan.nextLine();
        Teacher temp = controller.service.serviceT.createTeacher(name, lastName);
        temp.setIsNoGroup(true);
        temp.setGroupId(null);
        return temp;
    }

    public void swapStudent(){
        System.out.println("Список всех студентов: ");
        for (Student student : controller.service.serviceS.getAllStudents()) {
            System.out.println(student);
        }
        System.out.println("Введите id студента, которого хотите добавить в группу.");
        int id = scan.nextInt();
        Student tempS = controller.service.serviceS.getById(id);
        if(tempS.getGroupID() != null){
            controller.getGroupByGroupId(tempS.getGroupID()).getStudents().remove(tempS);
        }
        for (StudyGroup<Teacher, Student> groupS : controller.studyGroups) {
            viewGroups(groupS);
        }
        System.out.println("Введите id группы, в которую хотите добавить студента.");
        id = scan.nextInt();
        controller.getGroupByGroupId(id).setStudent(tempS);
    }

}
