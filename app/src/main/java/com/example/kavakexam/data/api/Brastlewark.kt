package com.example.kavakexam.data.api

import com.google.gson.annotations.SerializedName

data class Brastlewark(
    @SerializedName("age")
    val age: Int,
    @SerializedName("friends")
    val friends: List<String>,
    @SerializedName("hair_color")
    val hairColor: String,
    @SerializedName("height")
    val height: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("professions")
    val professions: List<String>,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("weight")
    val weight: Double
)