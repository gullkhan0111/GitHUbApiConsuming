package com.example.haseeb.tabactivity.features.userRepository;


import com.example.haseeb.tabactivity.data.Models.RepositoryModels;

import java.util.List;

public interface RepositoryView {
    void getRepoList(List<RepositoryModels> reposlists);
    void getReposListEror();

    void getEmptyListMessage();
}
