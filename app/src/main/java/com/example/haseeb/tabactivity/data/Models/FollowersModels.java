
package com.example.haseeb.tabactivity.data.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FollowersModels {
    private String login;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
