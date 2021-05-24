package com.example.kavakexam.data.source

import com.example.kavakexam.core.data.Resource
import com.example.kavakexam.core.data.source.RemoteGnomeSource
import com.example.kavakexam.core.domain.Gnome
import com.example.kavakexam.data.api.GnomeService
import com.example.kavakexam.presentation.utils.toDomain

class RemoteDataSourceImpl(private val gnomeService: GnomeService) : RemoteGnomeSource {

    override suspend fun getGnomes(): Resource<List<Gnome>> {

        return try {

            val response = gnomeService.getGnomes()

            if (response.code() == 200) {
                Resource.Success(
                    response.body()?.brastlewark?.map { it.toDomain() } ?: emptyList()
                )
            } else {
                Resource.ErrorBody("Some error occurs parsing response ")
            }

        } catch (ex: Exception) {
            Resource.ErrorException(ex)
        }

    }


}