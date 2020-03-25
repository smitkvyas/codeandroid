package com.codeandroid.userprofile_mvvm.data.models;

public class PersonalProfile {

    private String firstName;
    private String lastName;

    public PersonalProfile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PersonalProfile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
