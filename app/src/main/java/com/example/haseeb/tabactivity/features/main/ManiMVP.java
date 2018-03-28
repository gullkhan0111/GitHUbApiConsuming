package com.example.haseeb.tabactivity.features.main;

/**
 * Created by haseeb on 3/27/2018.
 */

public interface ManiMVP {
    interface view {
        void SearchUserInGitHubByName(String name);

    }

    interface Presenter {
        void PresentUserName(String name);
    }

}
