package com.example.haseeb.tabactivity.features.userRepository;

import com.example.haseeb.tabactivity.data.Models.RepositoryModels;
import com.example.haseeb.tabactivity.data.Repository;

import java.util.List;

/**
 * Created by haseeb on 3/28/2018.
 */

public class UserRepositoryPresenterImpl implements Repository.OnRepositoryCallback {

    private final RepositoryView repositoryView;
    private final Repository userProofileModel;

    public UserRepositoryPresenterImpl(RepositoryView repositoryView, Repository userProofileModel) {
        this.repositoryView = repositoryView;
        this.userProofileModel = userProofileModel;
    }
    public void getUserNameForSearchingRepository(String UserNameForRepository){
        userProofileModel.GetUserRepository(UserNameForRepository,this);
    }


    @Override
    public void GettingSuccessRepositoryList(List<RepositoryModels> reposlists) {
        repositoryView.getRepoList(reposlists);

    }

    @Override
    public void GettingEmptyRepositoryList() {
        repositoryView.getEmptyListMessage();

    }

    @Override
    public void GettingErrorRepositoryList() {
        repositoryView.getReposListEror();

    }
}
