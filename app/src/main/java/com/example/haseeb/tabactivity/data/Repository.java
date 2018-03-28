package com.example.haseeb.tabactivity.data;

import com.example.haseeb.tabactivity.data.Models.ContributorsModels;
import com.example.haseeb.tabactivity.data.Models.FollowersModels;
import com.example.haseeb.tabactivity.data.Models.RepositoryModels;
import com.example.haseeb.tabactivity.data.Models.UserProfileList;
import com.example.haseeb.tabactivity.provider.GetRetrofitObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Repository {

    public void GetUserProfile(String searchName, final OnProfileCallback callback) {
        GetRetrofitObject.getService().getUserProfile(searchName).enqueue(new Callback<UserProfileList>() {
            @Override
            public void onResponse(Call<UserProfileList> call, Response<UserProfileList> response) {

                if (response.isSuccessful() && response.body() != null) {
                    try {
                        callback.OnSuccess(response.body().getLogin(), response.body().getAvatarUrl(), response.body().getName().toString(), response.body().getBio().toString());
                    } catch (NullPointerException ex) {
                        ex.printStackTrace();

                    }
                }

            }

            @Override
            public void onFailure(Call<UserProfileList> call, Throwable t) {
                callback.OnFailed();

            }
        });
    }

    public void GetUserRepository(String searchName, final OnRepositoryCallback callback) {
        GetRetrofitObject.getService().GetRepositoryForUser(searchName).enqueue(new Callback<List<RepositoryModels>>() {
            @Override
            public void onResponse(Call<List<RepositoryModels>> call, Response<List<RepositoryModels>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<RepositoryModels> reposlists = response.body();
                        callback.GettingSuccessRepositoryList(reposlists);

                    } catch (NullPointerException ex) {
                        ex.printStackTrace();
                        callback.GettingEmptyRepositoryList();

                    }


                }

            }

            @Override
            public void onFailure(Call<List<RepositoryModels>> call, Throwable t) {
                callback.GettingErrorRepositoryList();

            }
        });


    }

    public void GetUserFollowers(String searchName, final OnFollowersCallback callback) {
        GetRetrofitObject.getService().GetFollowersforUser(searchName).enqueue(new Callback<List<FollowersModels>>() {
            @Override
            public void onResponse(Call<List<FollowersModels>> call, Response<List<FollowersModels>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        List<FollowersModels> followerslists = response.body();
                        callback.GettingSuccessFollowersList(followerslists);
                    } catch (NullPointerException ex) {
                        ex.printStackTrace();
                        callback.GettingEmptyFollowersList();

                    }


                }

            }

            @Override
            public void onFailure(Call<List<FollowersModels>> call, Throwable t) {
                callback.GettingErrorInFolloweresList();

            }
        });
    }

    public void GetContributorsForRepository(String ownerName, final String repositoryName, final OnContributorscallback callback){
        GetRetrofitObject.getService().getContributorsForUser(ownerName,repositoryName).enqueue(new Callback<List<ContributorsModels>>() {
            @Override
            public void onResponse(Call<List<ContributorsModels>> call, Response<List<ContributorsModels>> response) {
                try {
                    if(response.isSuccessful() && response.body()!=null ){
                        List<ContributorsModels> contributorsModels = response.body();
                        callback.GettingSuccessContribitorsList(contributorsModels);
                    }
                }catch (NullPointerException ex){
                    ex.printStackTrace();
                    callback.GettingEmptyContribitorsList();
                }


            }

            @Override
            public void onFailure(Call<List<ContributorsModels>> call, Throwable t) {
                callback.GettingErrorInContribitorsList();


            }
        });
    }




    public interface OnProfileCallback {
        void OnSuccess(String LogIn, String imagUrl, String name, String Bio);

        void OnFailed();
    }

    public interface OnRepositoryCallback {
        void GettingSuccessRepositoryList(List<RepositoryModels> reposlists);

        void GettingEmptyRepositoryList();

        void GettingErrorRepositoryList();
    }

    public interface OnFollowersCallback {
        void GettingSuccessFollowersList(List<FollowersModels> followerlist);

        void GettingErrorInFolloweresList();

        void GettingEmptyFollowersList();

    }

    public interface OnContributorscallback {
        void GettingSuccessContribitorsList(List<ContributorsModels> followerlist);
        void GettingErrorInContribitorsList();
        void GettingEmptyContribitorsList();


    }

}
