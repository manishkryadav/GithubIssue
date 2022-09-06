package com.example.githubissueapplication.api;

import com.example.githubissueapplication.model.GitHubIssueModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Apis {

    @GET("issues")
    Call<GitHubIssueModel> getIssue(
    );



//    @POST("/posts")
//    @FormUrlEncoded
//    Call<Post> savePost(@Field("title") String title,
//                        @Field("body") String body,
//                        @Field("userId") long userId);



}
