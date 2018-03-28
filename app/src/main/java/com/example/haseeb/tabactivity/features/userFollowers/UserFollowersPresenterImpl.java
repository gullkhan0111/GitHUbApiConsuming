package com.example.haseeb.tabactivity.features.userFollowers;

import com.example.haseeb.tabactivity.data.Models.FollowersModels;
import com.example.haseeb.tabactivity.data.Repository;

import java.util.List;

public class UserFollowersPresenterImpl implements Repository.OnFollowersCallback {
    private final Repository userProfileModel;
    private final FollowersView followersView;

    public UserFollowersPresenterImpl(Repository userProofileModel, FollowersView followersView) {
        this.userProfileModel = userProofileModel;
        this.followersView = followersView;
    }

    public void GettingFollowersForUser(String name) {
        userProfileModel.GetUserFollowers(name, this);
    }

    @Override
    public void GettingSuccessFollowersList(List<FollowersModels> followerlist) {
        followersView.GettingFollowersList(followerlist);

    }

    @Override
    public void GettingErrorInFolloweresList() {
        followersView.GettingErrorFollowersList();

    }

    @Override
    public void GettingEmptyFollowersList() {
        followersView.GettingtEmptyFollowersList();

    }
}
