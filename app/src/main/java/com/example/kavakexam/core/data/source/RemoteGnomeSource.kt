package com.example.kavakexam.core.data.source

import com.example.kavakexam.core.data.Resource
import com.example.kavakexam.core.domain.Gnome

interface RemoteGnomeSource {
    suspend fun getGnomes(): Resource<List<Gnome>>
}