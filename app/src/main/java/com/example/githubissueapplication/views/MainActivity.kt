package com.example.githubissueapplication.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.githubissueapplication.R
import com.example.githubissueapplication.viewmodels.GithubIssueViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: GithubIssueViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProviders.of(this)[GithubIssueViewModel::class.java]
        viewModel.init()
        viewModel.getVolumesResponseLiveData().observe(
            this
        ) { volumesResponse ->
            if (volumesResponse != null) {
//                adapter.setResults(volumesResponse.getItems())
            }
        }
        viewModel.searchVolumes()
    }
}