package com.example.haseeb.tabactivity.features.userFollowers;

import com.example.haseeb.tabactivity.data.Models.FollowersModels;

import java.util.List;

/**
 * Created by haseeb on 3/28/2018.
 */

public interface FollowersView {

    void GettingFollowersList(List<FollowersModels> followerslists);
    void GettingErrorFollowersList();
    void GettingtEmptyFollowersList();
}
