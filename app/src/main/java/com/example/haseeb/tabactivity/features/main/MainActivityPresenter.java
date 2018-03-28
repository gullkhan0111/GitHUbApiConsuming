package com.example.haseeb.tabactivity.features.main;

/**
 * Created by haseeb on 3/27/2018.
 */

public class MainActivityPresenter implements ManiMVP.Presenter {
    ManiMVP.view view;

    public MainActivityPresenter(ManiMVP.view view) {
        this.view = view;

    }
    @Override
    public void PresentUserName(String name) {
        view.SearchUserInGitHubByName(name);
    }
}
