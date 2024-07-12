package OOP_Task1.university.view;

import OOP_Task1.university.controller.StudyGroupController;
import OOP_Task1.university.model.impl.Student;

import java.util.List;
import java.util.Scanner;

public class View {
    
    Scanner scan = new Scanner(System.in);
    StudyGroupController controller;

    public View(StudyGroupController controller) {
        this.controller = controller;
    }

    public void start(){

        boolean isStart = true;
        

        while(isStart){
            System.out.println("1. Создать студента.");
            System.out.println("2. Найти студента по id.");
            System.out.println("3. Показать всех студентов.");
            System.out.println("4. Выход.");
            String menu = scan.nextLine();
            switch (menu) {

                case "1":
                    print();
                    break;
                case "2":
                    printById();
                    break;
                case "3":
                    printAll();
                    break;
                case "4":
                    isStart = false;
                    scan.close();
                    return;
                
            }
            
        }

        
    }

    public Student createStudent(){
        System.out.println("Введите имя: ");
        String name = scan.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scan.nextLine();
        Student temp = controller.service.serviceS.createStudent(name, lastName);
        return temp;
    }

    private Student getById(){
        System.out.println("Введите id пользователя: ");
        int id = scan.nextInt();
        return controller.service.serviceS.getById(id);
    }

    private List<Student> getAllStudents(){
        return controller.service.serviceS.getAllStudents();
    }

    public void printAll(){
        System.out.println(getAllStudents());
    }

    public void printById(){
        System.out.println(getById());
    }

    public void print(){
        System.out.println(createStudent());
    }
}
