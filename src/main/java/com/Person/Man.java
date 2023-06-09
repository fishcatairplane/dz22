package com.Person;

public class Man extends Person {
    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public void registerPartnership(Woman woman) {
        setPartner(woman);
        woman.setPartner(this);
        woman.setLastName(getLastName());
    }

    public boolean isRetired() {
        return super.isRetired(65);
    }
}