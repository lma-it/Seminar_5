package OOP_Task1.university.ecxeptions;

public class NotNullTeacherExpected extends UniversityException {

    public NotNullTeacherExpected(String msg) {
        super("Учитель при создании группы не должен являтся null объектом!");
    }
    
}
