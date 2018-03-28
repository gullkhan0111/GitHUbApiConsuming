package com.example.haseeb.tabactivity.features.userProfile;

public interface UserProfileView {
    void onSucess(String logIn, String LogName, String imagUrl, String Bio);
    void failed();

}
