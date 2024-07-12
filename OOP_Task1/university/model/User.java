package OOP_Task1.university.model;


public abstract class User {
    protected int id;
    protected String name;
    protected String lastName;
    private static int count = 1;

    public User(String name, String lastName) {
        this.id = count++;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName() + ": ID: %s, Name: %s, Last_Name: %s", this.id, this.name, this.lastName);
    }

    public int getId() {
        return id;
    }
}
