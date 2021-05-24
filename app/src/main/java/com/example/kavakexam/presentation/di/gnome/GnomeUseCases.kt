package com.example.kavakexam.presentation.di.gnome

import com.example.kavakexam.core.data.repository.GnomeRepository
import com.example.kavakexam.core.usescase.gnome.GetGnomes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class GnomeUseCases {

    @Provides
    @FragmentScoped
    fun provideGetGnomesUseCase(gnomeRepository: GnomeRepository) =
        GetGnomes(gnomeRepository = gnomeRepository)

}