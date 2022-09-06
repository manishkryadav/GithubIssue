package com.example.githubissueapplication.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.githubissueapplication.api.RetrofitClient;
import com.example.githubissueapplication.model.GitHubIssueModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubIssueRepository {
    private static final String BOOK_SEARCH_SERVICE_BASE_URL = "https://www.googleapis.com/";

    private RetrofitClient retrofitClient;
    private MutableLiveData<GitHubIssueModel> volumesResponseLiveData;

    public GithubIssueRepository() {
        volumesResponseLiveData = new MutableLiveData<>();
        retrofitClient= RetrofitClient.getInstance();

    }

    public void searchVolumes() {
        retrofitClient.getApi().getIssue()
                .enqueue(new Callback<GitHubIssueModel>() {
                    @Override
                    public void onResponse(Call<GitHubIssueModel> call, Response<GitHubIssueModel> response) {
                        if (response.body() != null) {
                            volumesResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<GitHubIssueModel> call, Throwable t) {
                        volumesResponseLiveData.postValue(null);
                    }
                });
    }


    public LiveData<GitHubIssueModel> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}
