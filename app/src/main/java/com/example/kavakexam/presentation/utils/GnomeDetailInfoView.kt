package com.example.kavakexam.presentation.utils

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.example.kavakexam.core.domain.Gnome


class GnomeDetailInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    fun setGnome(gnome: Gnome) = with(gnome) {
        text = buildSpannedString {

            bold { append("About: ${gnome.name}") }

            bold { append("Professions: ") }
            gnome.professions.forEach { profession ->
                append(profession.plus("\n"))
            }

            bold { append("Friends: ") }
            gnome.friends.forEach { friends ->
                append(friends.plus("\n"))
            }

            bold { append("Hair color: ") }
            appendln(gnome.hairColor)

            bold { append("age: ") }
            append(gnome.age.toString())
        }
    }
}