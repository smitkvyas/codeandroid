package com.codeandroid.userprofile_mvvm.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codeandroid.userprofile_mvvm.data.models.ContactProfile;
import com.codeandroid.userprofile_mvvm.data.models.PersonalProfile;
import com.codeandroid.userprofile_mvvm.data.models.User;
import com.codeandroid.userprofile_mvvm.data.repository.UserDataRepository;

public class UserViewModel extends ViewModel {

    public MutableLiveData<User> userLiveData = new MutableLiveData<>();

    public void getUserData() {
        getUserPersonalProfileData();
        getUserContactData();
    }

    private void getUserContactData() {
        ContactProfile contactProfile = new UserDataRepository().getUsersContactData();

        User user = userLiveData.getValue();
        if (user == null) {
            user = new User();
        }
        user.setContactProfile(contactProfile);
        userLiveData.setValue(user);
    }

    private void getUserPersonalProfileData() {
        PersonalProfile personalProfile = new UserDataRepository().getUsersPersonalProfileData();

        User user = userLiveData.getValue();
        if (user == null) {
            user = new User();
        }

        user.setPersonalProfile(personalProfile);
        userLiveData.setValue(user);
    }
}

