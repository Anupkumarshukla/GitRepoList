package com.anupkumarshukla.data.network.model

import com.anupkumarshukla.common.DateTime


data class GithubPullRequest(
    val title: String = "",
    val createdAt: DateTime = DateTime.Default,
    val closedAt: DateTime = DateTime.Default,
    val user: User? = User(),
)