package com.example.haseeb.tabactivity.features.userProfile;

import com.example.haseeb.tabactivity.features.main.ManiMVP;

/**
 * Created by haseeb on 3/27/2018.
 */

public class PresentationImpl implements ManiMVP.Presenter {

    ManiMVP.view view;

   public PresentationImpl(ManiMVP.view view) {
        this.view = view;
    }

    public void PresentUserName(String name) {

    }
}
