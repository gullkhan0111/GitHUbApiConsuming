package com.example.haseeb.tabactivity.features.userFollowers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.haseeb.tabactivity.R;
import com.example.haseeb.tabactivity.data.Models.FollowersModels;
import com.example.haseeb.tabactivity.features.userProfile.UserProfileActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class FollowerAdapter extends RecyclerView.Adapter<FollowerAdapter.FollowersViewHolder> {
    private Context context;

    private List<FollowersModels> followerslists = new ArrayList<>();

    public FollowerAdapter(Context context, List<FollowersModels> followerslists) {
        this.followerslists = followerslists;
        this.context = context;


    }


    @Override
    public FollowersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.followers_list_row, parent, false);
        return new FollowersViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final FollowersViewHolder holder, final int position) {
        holder.follow.setText(followerslists.get(position).getLogin());
        Picasso.get().load(followerslists.get(position).getAvatarUrl()).into(holder.followers_profile_image);


        holder.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  sendFollowwersListener.sendFollowersName(String.valueOf(followerslists.get(holder.getAdapterPosition())));
                Log.d("name", followerslists.get(position).getLogin());
                Intent intent = new Intent(context, UserProfileActivity.class);
                intent.putExtra("username", followerslists.get(position).getLogin().toString());
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return followerslists.size();
    }

    public class FollowersViewHolder extends RecyclerView.ViewHolder {
        TextView follow;
        ImageView followers_profile_image;

        public FollowersViewHolder(View itemView) {
            super(itemView);
            follow = itemView.findViewById(R.id.follow);
            followers_profile_image = itemView.findViewById(R.id.followers_profile_image);
        }
    }


}
