package com.example.haseeb.tabactivity.provider;

import com.example.haseeb.tabactivity.data.GitHubClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRetrofitObject {

    static String BASE_URL = "https://api.github.com/";
    public static GitHubClient gitHubClient = null;

    public static GitHubClient getService() {
        if (gitHubClient == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            gitHubClient = retrofit.create(GitHubClient.class);
        }
        return gitHubClient;
    }
}