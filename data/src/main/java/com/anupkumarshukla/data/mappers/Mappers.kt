package com.anupkumarshukla.githubpullrequest

import com.anupkumarshukla.common.splitDateTime
import com.anupkumarshukla.data.network.dto.GithubPullRequestDTO
import com.anupkumarshukla.data.network.model.GithubPullRequest
import com.anupkumarshukla.data.network.model.User


fun List<GithubPullRequestDTO>.toDomain(): List<GithubPullRequest> {

    return map {
        GithubPullRequest(
            title = it.title ?: "",
            closedAt = it.closedAt.splitDateTime(),
            createdAt = it.createdAt.splitDateTime(),
            user = it.user?.toDomain()
        )
    }

}


fun GithubPullRequestDTO.User.toDomain(): User {
    return User(avatarUrl, login)
}
