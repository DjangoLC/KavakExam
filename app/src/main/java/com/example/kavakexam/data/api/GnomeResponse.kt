package com.example.kavakexam.data.api


import com.google.gson.annotations.SerializedName

data class GnomeResponse(
    @SerializedName("Brastlewark")
    val brastlewark: List<Brastlewark>
)