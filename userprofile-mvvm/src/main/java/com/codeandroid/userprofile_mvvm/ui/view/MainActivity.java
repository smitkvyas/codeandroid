package com.codeandroid.userprofile_mvvm.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.codeandroid.userprofile_mvvm.R;
import com.codeandroid.userprofile_mvvm.data.models.ContactProfile;
import com.codeandroid.userprofile_mvvm.data.models.PersonalProfile;
import com.codeandroid.userprofile_mvvm.data.models.User;
import com.codeandroid.userprofile_mvvm.ui.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.userLiveData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    updatePersonalProfileUI(user.getPersonalProfile());
                    updateContactProfileUI(user.getContactProfile());
                }
            }
        });

        userViewModel.getUserData();
    }

    private void updateContactProfileUI(ContactProfile contactProfile) {
        if (contactProfile != null) {
            Log.d("Code Android", "updateContactProfileUI() called with: contactProfile = [" + contactProfile.toString() + "]");
            // update contact profile UI
        }
    }

    private void updatePersonalProfileUI(PersonalProfile personalProfile) {
        if (personalProfile != null) {
            Log.d("Code Android", "updatePersonalProfileUI() called with: personalProfile = [" + personalProfile.toString() + "]");
            // update personal profile UI
        }
    }
}
