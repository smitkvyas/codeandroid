package com.codeandroid.userprofile_mvvm.data.models;

public class User {

    public PersonalProfile personalProfile;
    public ContactProfile contactProfile;

    public PersonalProfile getPersonalProfile() {
        return personalProfile;
    }

    public User setPersonalProfile(PersonalProfile personalProfile) {
        this.personalProfile = personalProfile;
        return this;
    }

    public ContactProfile getContactProfile() {
        return contactProfile;
    }

    public User setContactProfile(ContactProfile contactProfile) {
        this.contactProfile = contactProfile;
        return this;
    }
}
