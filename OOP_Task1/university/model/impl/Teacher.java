package OOP_Task1.university.model.impl;

import OOP_Task1.university.model.User;

public class Teacher extends User{

    private Integer groupID = null;
    private boolean isNoGroup;

    public Teacher(String name, String lastName) {
        super(name, lastName);
    }

    public void setGroupId(Integer groupId){
        this.groupID = groupId;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public void setIsNoGroup(boolean isNoGroup) {
        this.isNoGroup = isNoGroup;
    }

    public boolean getIsNoGroup(){
        return this.isNoGroup;
    }

    public Integer getGroupID() {
        return this.groupID;
    }

    @Override
    public String toString() {

        if(this.getGroupID() != null){
            return String.format("\n%s groupId: %s", super.toString(), this.getGroupID());
        }
        return String.format("\n%s groupId %s", super.toString(), "null");
    }
    
}
