package com.anupkumarshukla.githubpullrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.anupkumarshukla.githubpullrequest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel:MainViewModel by viewModels()
    @Inject
     lateinit var pullRequestPagerAdapter: PullRequestPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerview()
        lifecycleScope.launchWhenStarted {
            mainViewModel.getPullRequest.collectLatest { response->
                binding.apply {
                   progressBar.isVisible=false
                    recyclerview.isVisible=true
                }
                pullRequestPagerAdapter.submitData(response)
            }
        }
    }

    private fun initRecyclerview() {
        binding.apply {
            recyclerview.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = pullRequestPagerAdapter.withLoadStateHeaderAndFooter(
                    header = LoaderStateAdapter { pullRequestPagerAdapter :: retry},
                    footer = LoaderStateAdapter{pullRequestPagerAdapter :: retry}
                )
            }
        }
    }
}
