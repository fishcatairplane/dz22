package com.Person;

public class Person {
    public String firstName;
    public String lastName;
    public int age;
    private Person partner;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public void registerPartnership(Person person) {
        person.setPartner(this);
        setPartner(person);
    }

    public void deregisterPartnership() {
        partner.setPartner(null);
        setPartner(null);
    }

    public boolean isRetired(int retiredAge) {
        return age >= retiredAge;
    }
}