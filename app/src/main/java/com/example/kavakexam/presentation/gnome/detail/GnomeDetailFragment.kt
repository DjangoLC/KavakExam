package com.example.kavakexam.presentation.gnome.detail

import androidx.navigation.fragment.navArgs
import com.example.kavakexam.R
import com.example.kavakexam.databinding.FragmentGnomeDetailBinding
import com.example.kavakexam.presentation.utils.BaseFragmentBinding

class GnomeDetailFragment :
    BaseFragmentBinding<FragmentGnomeDetailBinding>(R.layout.fragment_gnome_detail) {

    private val args:GnomeDetailFragmentArgs by navArgs()

    override fun initComponent() {

        binding.gnome = args.gnome
        binding.executePendingBindings()

    }

}