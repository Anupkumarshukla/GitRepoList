package com.anupkumarshukla.data

import com.anupkumarshukla.data.network.dto.GithubPullRequestDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("repos/square/retrofit/pulls")
    suspend fun fetchPullRequests(
        @Query("state") status: String,
        @Query("per_page") perPage: Int,
        @Query("page") pageNo: Int,
    ): Response<List<GithubPullRequestDTO>>
}