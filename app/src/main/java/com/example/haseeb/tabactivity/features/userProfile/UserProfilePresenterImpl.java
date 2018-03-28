package com.example.haseeb.tabactivity.features.userProfile;

import com.example.haseeb.tabactivity.data.Repository;

/**
 * Created by haseeb on 3/28/2018.
 */

public class UserProfilePresenterImpl  implements Repository.OnProfileCallback {
    private final UserProfileView userProfileView;
    private final Repository userProofileModel;

    public UserProfilePresenterImpl(UserProfileView userProfileView, Repository userProofileModel) {
        this.userProfileView = userProfileView;
        this.userProofileModel = userProofileModel;
    }
    public void GetSearchName(String name){
        userProofileModel.GetUserProfile(name,this);
    }


    @Override
    public void OnSuccess(String LogIn, String imagUrl, String name, String Bio) {
        userProfileView.onSucess(LogIn,imagUrl,name,Bio);

    }

    @Override
    public void OnFailed() {

    }
}
