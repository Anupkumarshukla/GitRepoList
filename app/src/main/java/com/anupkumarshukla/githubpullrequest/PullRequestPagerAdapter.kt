package com.anupkumarshukla.githubpullrequest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.anupkumarshukla.common.attributedText
import com.anupkumarshukla.data.network.model.GithubPullRequest
import com.anupkumarshukla.githubpullrequest.databinding.RvItemBinding
import javax.inject.Inject

class PullRequestPagerAdapter @Inject constructor() : PagingDataAdapter<GithubPullRequest,PullRequestPagerAdapter.PullRequestViewHolder>(Diff()) {


    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        val githubPR = getItem(position)
        if(githubPR!= null){
            holder.binds(githubPR)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder  =
        PullRequestViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    class PullRequestViewHolder(private val binding:RvItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun binds(githubPullRequest: GithubPullRequest){
            binding.apply {
                ivUserImage.load(githubPullRequest.user?.avatarUrl)
                tvTitle.text = githubPullRequest.title
                tvUserName.text = githubPullRequest.user?.name
                tvCreatedAt.attributedText(
                    R.string.created_at_s,
                    githubPullRequest.createdAt.date, githubPullRequest.createdAt.time
                )
                tvClosedAt.attributedText(
                    R.string.closed_at_s,
                    githubPullRequest.closedAt.date, githubPullRequest.closedAt.time
                )
                tvUserName.attributedText(R.string.userid_s, githubPullRequest.user?.name)
            }
        }
    }

    class Diff : DiffUtil.ItemCallback<GithubPullRequest>(){
        override fun areItemsTheSame(oldItem: GithubPullRequest, newItem: GithubPullRequest): Boolean  =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: GithubPullRequest, newItem: GithubPullRequest): Boolean =
            oldItem == newItem
    }
}