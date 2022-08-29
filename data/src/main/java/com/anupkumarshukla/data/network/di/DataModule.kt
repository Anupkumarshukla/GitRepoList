package com.anupkumarshukla.data.network.di

import com.anupkumarshukla.data.ApiService
import com.anupkumarshukla.data.repository.GithubPullRequestRepository
import com.anupkumarshukla.data.repository.GithubPullRequestRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun providesApiService() = Retrofit
        .Builder()
        .baseUrl(com.anupkumarshukla.common.Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)!!

    @Provides
    fun provideGetPullRequestRepository(apiService: ApiService): GithubPullRequestRepository {
        return GithubPullRequestRepositoryImpl(apiService = apiService)
    }

}