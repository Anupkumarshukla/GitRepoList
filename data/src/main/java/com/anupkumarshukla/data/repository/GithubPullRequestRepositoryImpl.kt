package com.anupkumarshukla.data.repository

import com.anupkumarshukla.data.ApiService
import com.anupkumarshukla.data.network.model.GithubPullRequest
import com.anupkumarshukla.data.network.utils.SafeApiRequest
import com.anupkumarshukla.githubpullrequest.toDomain
import javax.inject.Inject


class GithubPullRequestRepositoryImpl @Inject constructor(private val apiService: ApiService): GithubPullRequestRepository , SafeApiRequest() {

    override suspend fun getPullRequest(status: String,
                                  perPage: Int,
                                  pageNo: Int): List<GithubPullRequest> {
        val response = safeApiRequest { apiService.fetchPullRequests(status,perPage,pageNo) }
        return response?.toDomain()?: emptyList()
    }
}