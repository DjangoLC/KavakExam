package com.example.kavakexam.presentation.di.gnome

import com.example.kavakexam.core.data.repository.GnomeRepository
import com.example.kavakexam.core.data.repository.GnomeRepositoryImpl
import com.example.kavakexam.core.data.source.RemoteGnomeSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class GnomeRepoModule {

    @ActivityScoped
    @Provides
    fun provideProductsRepository(remoteDataSource: RemoteGnomeSource) :
            GnomeRepository = GnomeRepositoryImpl(remoteDataSource)

}