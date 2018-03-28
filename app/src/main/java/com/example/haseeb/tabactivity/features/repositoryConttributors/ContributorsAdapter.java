package com.example.haseeb.tabactivity.features.repositoryConttributors;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.haseeb.tabactivity.data.Models.ContributorsModels;
import com.example.haseeb.tabactivity.features.userProfile.UserProfileActivity;
import com.example.haseeb.tabactivity.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContributorsAdapter extends RecyclerView.Adapter<ContributorsAdapter.ContributorsViewHolder> {

    List<ContributorsModels> contributors;
    Context context;

    public ContributorsAdapter(Context context, List<ContributorsModels> body) {
        this.contributors = body;
        this.context = context;
    }

    @Override
    public ContributorsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contributorslistview, parent, false);
        return new ContributorsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContributorsViewHolder holder, final int position) {
        holder.contri_name.setText(contributors.get(position).getLogin());
        Picasso.get().load(contributors.get(position).getAvatar_url()).into(holder.contr_profile_image);
        holder.contr_profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserProfileActivity.class);
                intent.putExtra("username", contributors.get(position).getLogin());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return contributors.size();
    }

    public class ContributorsViewHolder extends RecyclerView.ViewHolder {
        ImageView contr_profile_image;
        TextView contri_name;

        public ContributorsViewHolder(View itemView) {
            super(itemView);
            contr_profile_image = itemView.findViewById(R.id.contributors_profile_image);
            contri_name = itemView.findViewById(R.id.contributors_name);

        }
    }
}
