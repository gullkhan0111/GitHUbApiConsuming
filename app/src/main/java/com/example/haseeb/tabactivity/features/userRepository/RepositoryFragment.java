package com.example.haseeb.tabactivity.features.userRepository;

import android.content.Intent;
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
import com.example.haseeb.tabactivity.data.Models.RepositoryModels;
import com.example.haseeb.tabactivity.data.Repository;

import java.util.List;


public class RepositoryFragment extends Fragment implements RepoAdatpter.ObjectListener, RepositoryView {
    RepoAdatpter adatpter;
    RecyclerView recyclerView;
    ProgressBar repo_bar;
    String userName;
    RepoAdatpter.ObjectListener objectListener;
    UserRepositoryPresenterImpl presenter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Toast.makeText(getContext(), "frage Follow call", Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.repo_fragment, container, false);


    }

    public static RepositoryFragment newInstance(String s, String username) {

        Bundle args = new Bundle();
        RepositoryFragment fragment = new RepositoryFragment();
        args.putString(s, username);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userName = getArguments().getString("username");
        // adatpter.intlizeListener(this);
        adatpter = new RepoAdatpter(getActivity(), this);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new UserRepositoryPresenterImpl(this, new Repository());

        presenter.getUserNameForSearchingRepository(userName);
        recyclerView = view.findViewById(R.id.Repository_listView);
        repo_bar = view.findViewById(R.id.repo_bar);
        repo_bar.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }


    @Override
    public void sendObject(RepositoryModels repoList) {

        Intent intent = new Intent(getActivity(), ReposDetailActivity.class);
        intent.putExtra("repo", repoList);
        startActivity(intent);


    }

    @Override
    public void getRepoList(List<RepositoryModels> reposlists) {
        recyclerView.setAdapter(new RepoAdatpter(getContext(), this));
        recyclerView.setAdapter(adatpter);
        adatpter.intilizeList(reposlists);
        repo_bar.setVisibility(View.INVISIBLE);


    }

    @Override
    public void getReposListEror() {
        Toast.makeText(getContext(), "Some Error Occured in getting Repository", Toast.LENGTH_SHORT).show();
        repo_bar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void getEmptyListMessage() {
        Toast.makeText(getContext(), "Sorrey Repository List is Empty", Toast.LENGTH_SHORT).show();
        repo_bar.setVisibility(View.INVISIBLE);
    }
}

