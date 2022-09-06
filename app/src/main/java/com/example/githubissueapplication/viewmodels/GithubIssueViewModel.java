package com.example.githubissueapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.githubissueapplication.model.GitHubIssueModel;
import com.example.githubissueapplication.repositories.GithubIssueRepository;


public class GithubIssueViewModel extends AndroidViewModel {
    private GithubIssueRepository mGithubIssueRepository;
    private LiveData<GitHubIssueModel> volumesResponseLiveData;

    public GithubIssueViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        mGithubIssueRepository = new GithubIssueRepository();
        volumesResponseLiveData = mGithubIssueRepository.getVolumesResponseLiveData();
    }

    public void searchVolumes() {
        mGithubIssueRepository.searchVolumes();
    }

    public LiveData<GitHubIssueModel> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}
