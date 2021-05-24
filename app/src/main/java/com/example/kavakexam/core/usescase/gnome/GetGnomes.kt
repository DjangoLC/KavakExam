package com.example.kavakexam.core.usescase.gnome

import com.example.kavakexam.core.data.repository.GnomeRepository
import javax.inject.Inject

class GetGnomes  @Inject constructor(private val gnomeRepository: GnomeRepository) {

    suspend fun invoke() = gnomeRepository.getGnomes()

}