package com.example.haseeb.tabactivity.features.userRepository;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.haseeb.tabactivity.R;
import com.example.haseeb.tabactivity.data.Models.RepositoryModels;

import java.security.acl.Owner;
import java.util.List;


public class RepoAdatpter extends RecyclerView.Adapter<RepoAdatpter.RepoViewHolder> {
    private List<RepositoryModels> repoLists;
    private Context context;
    List<Owner>owner;
    ObjectListener objectListener;
    private int previousPosition = 0;


    public RepoAdatpter(Context activity, ObjectListener objectListener) {
        this.context = activity;
        this.objectListener = objectListener;

    }

    public void intilizeList(List<RepositoryModels> repoLists) {
        this.repoLists = repoLists;

    }


    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repo_list_row, parent, false);
        return new RepoViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final RepoViewHolder holder, int position) {
        holder.txt.setText(repoLists.get(position).getName());

      /*  if (position > previousPosition) {

            AnimationUtil.animate(holder, true);

        } else {

            AnimationUtil.animate(holder, false);

        }

        previousPosition = position;

        final int currentPosition = position;

        final RepositoryModels infoData = repoLists.get(position);*/


        holder.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectListener.sendObject(repoLists.get(holder.getAdapterPosition()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return repoLists.size();
    }

    public void intlizeListener(ObjectListener objectListener) {
        this.objectListener = objectListener;
    }


    public class RepoViewHolder extends RecyclerView.ViewHolder {
        TextView txt;

        public RepoViewHolder(View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
        }
    }

    public interface ObjectListener {
        void sendObject(RepositoryModels repoList);
    }
}
