package com.example.haseeb.tabactivity.features.repositoryConttributors;

import com.example.haseeb.tabactivity.data.Models.ContributorsModels;
import com.example.haseeb.tabactivity.data.Repository;

import java.util.List;

/**
 * Created by haseeb on 3/28/2018.
 */

public class ContributorsPresenterImpl  implements Repository.OnContributorscallback {

    private final ContributorsView contributorsView;
    private final Repository repository;

    public ContributorsPresenterImpl(ContributorsView contributorsView, Repository repository) {
        this.contributorsView = contributorsView;
        this.repository = repository;
    }

    public void GettingContributorsForRepository(String ownerName,String repositoryName){
        repository.GetContributorsForRepository(ownerName,repositoryName,this);

    }

    @Override
    public void GettingSuccessContribitorsList(List<ContributorsModels> followerlist) {
        contributorsView.GettingContributorsList(followerlist);

    }

    @Override
    public void GettingErrorInContribitorsList() {
        contributorsView.GettingtEmptyContributors();

    }

    @Override
    public void GettingEmptyContribitorsList() {
        contributorsView.GettingErrorContributorsList();

    }
}
