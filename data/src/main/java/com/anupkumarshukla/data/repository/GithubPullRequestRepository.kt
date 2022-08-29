package com.anupkumarshukla.data.repository

import com.anupkumarshukla.data.network.model.GithubPullRequest


interface GithubPullRequestRepository {

    suspend fun getPullRequest(status: String,
                         perPage: Int,
                         pageNo: Int):List<GithubPullRequest>

}