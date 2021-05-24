package com.example.kavakexam.core.data.repository

import com.example.kavakexam.core.data.Resource
import com.example.kavakexam.core.domain.Gnome

interface GnomeRepository {

    suspend fun getGnomes() : Resource<List<Gnome>>

}