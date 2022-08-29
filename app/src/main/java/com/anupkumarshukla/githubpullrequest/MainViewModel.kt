package com.anupkumarshukla.githubpullrequest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.anupkumarshukla.common.Constant
import com.anupkumarshukla.data.network.model.GithubPullRequest
import com.anupkumarshukla.data.repository.GithubPullRequestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val getPullRequestRepository: GithubPullRequestRepository) : ViewModel() {
    val getPullRequest:Flow<PagingData<GithubPullRequest>> = Pager(config = PagingConfig(Constant.PERPAGE,enablePlaceholders = false)){
        PullRequestPageSource(getPullRequestRepository)
    }.flow.cachedIn(viewModelScope)


}
