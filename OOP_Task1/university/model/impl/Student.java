package OOP_Task1.university.model.impl;

import OOP_Task1.university.model.User;

public class Student extends User {

    private Integer groupID = null;

    public Student(String name, String lastName) {
        super(name, lastName);
    }

    public Integer getGroupID() {
        return groupID;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    @Override
    public String toString() {
        return String.format("\n%s groupId: %s", super.toString(), this.getGroupID());
    }
    
}
