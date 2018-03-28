package com.example.haseeb.tabactivity.features.userFollowers;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.haseeb.tabactivity.data.Models.FollowersModels;
import com.example.haseeb.tabactivity.data.Repository;
import com.example.haseeb.tabactivity.R;

import java.util.List;


public class FollowersFragment extends Fragment implements FollowersView {
    FollowerAdapter adapter;
    RecyclerView recyclerView;
    ProgressBar follow_bar;
    String userName;
    UserFollowersPresenterImpl presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.followers_fragment, container, false);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userName = getArguments().getString("username");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.folloers_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        follow_bar = view.findViewById(R.id.follow_bar);
        follow_bar.setVisibility(View.VISIBLE);
        presenter = new UserFollowersPresenterImpl(new Repository(), this);

        presenter.GettingFollowersForUser(userName);


    }

    public static FollowersFragment newInstance(String s, String username) {

        Bundle args = new Bundle();

        FollowersFragment fragment = new FollowersFragment();
        args.putString(s, username);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void GettingFollowersList(List<FollowersModels> followerslists) {
        recyclerView.setAdapter(new FollowerAdapter(getActivity(), followerslists));
        follow_bar.setVisibility(View.INVISIBLE);


    }

    @Override
    public void GettingErrorFollowersList() {
        Toast.makeText(getContext(), "Error ocurred in getting FollowerList for user", Toast.LENGTH_SHORT).show();
        follow_bar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void GettingtEmptyFollowersList() {
        Toast.makeText(getContext(), "Sorrry FolloersList is Empty", Toast.LENGTH_SHORT).show();
        follow_bar.setVisibility(View.INVISIBLE);
    }
}