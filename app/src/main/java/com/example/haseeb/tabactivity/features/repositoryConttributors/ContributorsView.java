package com.example.haseeb.tabactivity.features.repositoryConttributors;

import com.example.haseeb.tabactivity.data.Models.ContributorsModels;

import java.util.List;

/**
 * Created by haseeb on 3/28/2018.
 */

public interface ContributorsView  {

    void GettingContributorsList(List<ContributorsModels> contributorsModels);
    void GettingErrorContributorsList();
    void GettingtEmptyContributors();
}
