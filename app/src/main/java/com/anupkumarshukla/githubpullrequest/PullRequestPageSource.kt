package com.anupkumarshukla.githubpullrequest

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.anupkumarshukla.common.Constant
import com.anupkumarshukla.data.network.model.GithubPullRequest
import com.anupkumarshukla.data.repository.GithubPullRequestRepository
import retrofit2.HttpException
import java.io.IOException

class PullRequestPageSource constructor(private val getPullRequestRepository: GithubPullRequestRepository) : PagingSource<Int, GithubPullRequest>() {

    private val DEFAULT_PAGE_INDEX= 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubPullRequest> {
        val page = params.key ?: DEFAULT_PAGE_INDEX
        return try {
            val response = getPullRequestRepository.getPullRequest(
                Constant.CLOSED,
                Constant.PERPAGE,page)
            LoadResult.Page(
                response,
                prevKey = if(page == DEFAULT_PAGE_INDEX) null else page-1,
                nextKey = if(response.isEmpty()) null else page+1
            )
        } catch (exception:IOException){
            LoadResult.Error(exception)
        } catch (exception:HttpException){
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, GithubPullRequest>): Int? {
     return null
    }
}
