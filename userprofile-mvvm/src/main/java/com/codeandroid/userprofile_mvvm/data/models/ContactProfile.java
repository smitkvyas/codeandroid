package com.codeandroid.userprofile_mvvm.data.models;

public class ContactProfile {

    private String mobileNumber;
    private String emailId;

    public ContactProfile(String mobileNumber, String emailId) {
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "ContactProfile{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
