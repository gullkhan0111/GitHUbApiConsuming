package com.example.haseeb.tabactivity.data;


import com.example.haseeb.tabactivity.data.Models.ContributorsModels;
import com.example.haseeb.tabactivity.data.Models.FollowersModels;
import com.example.haseeb.tabactivity.data.Models.UserProfileList;
import com.example.haseeb.tabactivity.data.Models.RepositoryModels;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GitHubClient {

    // https://api.github.com/users/haseeb

    @GET("/users/{username}")
    Call<UserProfileList> getUserProfile(@Path("username") String user);

    //https://api.github.com/users/haseeb/repos
    @GET("/users/{username}/repos")
    Call<List<RepositoryModels>> GetRepositoryForUser(@Path("username") String user);

    // https://api.github.com/users/samaralii/followers

    @GET("/users/{username}/followers")
    Call<List<FollowersModels>> GetFollowersforUser(@Path("username") String user);

    //  https://api.github.com/repos/samaralii/DLM/contributors

    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<ContributorsModels>> getContributorsForUser(@Path("owner") String owner, @Path("repo") String repo);


}
