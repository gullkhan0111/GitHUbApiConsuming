package com.example.haseeb.tabactivity.features.repositoryConttributors;

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

import com.example.haseeb.tabactivity.R;
import com.example.haseeb.tabactivity.data.Models.ContributorsModels;
import com.example.haseeb.tabactivity.data.Repository;

import java.util.List;


public class ContributorsFragment extends Fragment implements ContributorsView {

    String ownerName, RepoName;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    String part1;
    ContributorsPresenterImpl presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_read_me, container, false);
    }

    public static ContributorsFragment newInstance(String ownerName, String repoName) {

        Bundle args = new Bundle();
        args.putString("owner", ownerName);
        args.putString("repoName", repoName);
        ContributorsFragment fragment = new ContributorsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownerName = getArguments().getString("owner");
        String[] finalOwnerName = ownerName.split("/");
        part1 = finalOwnerName[0];
        RepoName = getArguments().getString("repoName");


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.contibutorsList);
        presenter = new ContributorsPresenterImpl(this, new Repository());

        presenter.GettingContributorsForRepository(ownerName, RepoName);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar = view.findViewById(R.id.contributpr_bar);
        progressBar.setVisibility(View.VISIBLE);


    }

    @Override
    public void GettingContributorsList(List<ContributorsModels> contributorsModels) {
        recyclerView.setAdapter(new ContributorsAdapter(getContext(), contributorsModels));
        progressBar.setVisibility(View.INVISIBLE);


    }

    @Override
    public void GettingErrorContributorsList() {
        Toast.makeText(getContext(), "Error in getting Contributors", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void GettingtEmptyContributors() {
        Toast.makeText(getContext(), "Getting Empty Contributors List", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.INVISIBLE);
    }
}
