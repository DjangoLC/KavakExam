package com.example.kavakexam.presentation.utils

import com.example.kavakexam.core.domain.Gnome
import com.example.kavakexam.data.api.Brastlewark
import com.example.kavakexam.data.api.GnomeResponse

fun Brastlewark.toDomain() =
    Gnome(
        age, friends, hairColor, height, id, name, professions, thumbnail, weight
    )