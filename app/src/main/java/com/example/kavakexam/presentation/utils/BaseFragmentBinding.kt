package com.example.kavakexam.presentation.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

abstract class BaseFragmentBinding<B : ViewDataBinding>(private val resId: Int) : Fragment(resId) {

    lateinit var binding: B

    val loader: AlertDialog by lazy {
        AlertDialog.Builder(requireContext())
            .setTitle("Loading")
            .setMessage("Please wait a second while load your data!")
            .create()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, resId, container, false)!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
    }

    abstract fun initComponent()

    fun showErrorDialog(message: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("ups!")
            .setMessage(message)
            .setPositiveButton("Ok") { d, _ ->
                d.dismiss()
            }
            .create()
            .show()
    }

}