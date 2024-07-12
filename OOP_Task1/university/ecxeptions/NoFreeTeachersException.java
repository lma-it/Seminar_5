package OOP_Task1.university.ecxeptions;

public class NoFreeTeachersException extends UniversityException{

    public NoFreeTeachersException(String msg) {
        super("Нету свободных преподавателей. Все текущие преподаватели уже заняты в своих группах.");
    }
    
}
