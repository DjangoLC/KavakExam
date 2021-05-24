package com.example.kavakexam.core.data.repository

import com.example.kavakexam.core.data.Resource
import com.example.kavakexam.core.data.source.RemoteGnomeSource
import com.example.kavakexam.core.domain.Gnome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GnomeRepositoryImpl(private val remoteGnomeSource: RemoteGnomeSource) : GnomeRepository {
    override suspend fun getGnomes(): Resource<List<Gnome>> {
        return withContext(Dispatchers.IO) {
            remoteGnomeSource.getGnomes()
        }
    }
}