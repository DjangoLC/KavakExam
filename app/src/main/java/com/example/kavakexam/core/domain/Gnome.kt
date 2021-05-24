package com.example.kavakexam.core.domain

import java.io.Serializable

class Gnome (
    val age: Int,
    val friends: List<String>,
    val hairColor: String,
    val height: Double,
    val id: Int,
    val name: String,
    val professions: List<String>,
    val thumbnail: String,
    val weight: Double
) : Serializable