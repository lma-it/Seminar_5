package OOP_Task1.university.model.DB;
import java.util.List;

import OOP_Task1.university.controller.StudyGroupController;
import OOP_Task1.university.model.impl.Student;
import OOP_Task1.university.model.impl.Teacher;

// симулирует базу данных.
public class DateBase {
    StudyGroupController controller;

    public DateBase(StudyGroupController controller) {
        this.controller = controller;
    }

    public void fillDB(){
        Teacher teacher = new Teacher("Mr. John", "Williams");
        Teacher teacher1 = new Teacher("Mr. Aleks", "Smith");
        Teacher teacher2 = new Teacher("Ms. Jane", "Vilkins");
        Teacher teacher3 = new Teacher("Mr. Lu", "Chong");

        controller.service.serviceT.getAllTeachers().addAll(List.of(teacher, teacher1, teacher2, teacher3));
        
        controller.service.serviceS.getAllStudents().addAll(List.of(new Student("Anna", "Ivanova"), 
                                                                    new Student("Bill", "Smith"), 
                                                                    new Student("Lyuda", "Leonova"), 
                                                                    new Student("Anjella", "Garikovna"), 
                                                                    new Student("Igor", "Leonov"), 
                                                                    new Student("Will", "Aleks"), 
                                                                    new Student("Neal", "Olaf"), 
                                                                    new Student("Lev", "Kotov"), 
                                                                    new Student("Galya", "Ilina"), 
                                                                    new Student("Ivan", "Sergeev"), 
                                                                    new Student("Olga", "Olegova"), 
                                                                    new Student("Chu", "Young"), 
                                                                    new Student("Seb", "CJ")));
    }

}
