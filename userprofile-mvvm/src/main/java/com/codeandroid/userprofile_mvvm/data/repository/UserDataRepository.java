package com.codeandroid.userprofile_mvvm.data.repository;

import com.codeandroid.userprofile_mvvm.data.models.ContactProfile;
import com.codeandroid.userprofile_mvvm.data.models.PersonalProfile;

public class UserDataRepository {


    public ContactProfile getUsersContactData() {
        /*
        * include an API call or database operation
        * or other channel from were data can be retrieved
        *
        * to remove complexity we will just send back data
        * */
        return new ContactProfile("9876543210","support@codeandroid.co.in");
    }

    public PersonalProfile getUsersPersonalProfileData() {
        /*
         * include an API call or database operation
         * or other channel from were data can be retrieved
         *
         * to remove complexity we will just send back data
         * */
        return new PersonalProfile("Code","Android");
    }
}
