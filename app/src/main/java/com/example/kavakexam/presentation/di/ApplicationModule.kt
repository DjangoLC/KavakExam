package com.example.kavakexam.presentation.di

import com.example.kavakexam.core.data.source.RemoteGnomeSource
import com.example.kavakexam.data.api.GnomeService
import com.example.kavakexam.data.source.RemoteDataSourceImpl
import com.example.kavakexam.presentation.utils.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {


    @Provides
    @Singleton
    fun provideRetrofit():
            Retrofit = RetrofitService.getInstance()

    @Provides
    @Singleton
    fun provideUiDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @Singleton
    fun provideGnomeService(retrofit: Retrofit): GnomeService =
        retrofit.create(GnomeService::class.java)

    @Provides
    @Singleton
    fun provideGnomeSource(service: GnomeService): RemoteGnomeSource =
        RemoteDataSourceImpl(service)



}