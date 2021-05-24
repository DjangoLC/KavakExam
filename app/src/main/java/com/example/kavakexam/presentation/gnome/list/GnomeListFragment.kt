package com.example.kavakexam.presentation.gnome.list

import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kavakexam.R
import com.example.kavakexam.core.domain.Gnome
import com.example.kavakexam.databinding.FragmentGnomeListBinding
import com.example.kavakexam.presentation.utils.BaseFragmentBinding
import com.example.kavakexam.presentation.utils.BaseUiModel
import com.example.kavakexam.presentation.utils.EventObserver
import com.example.kavakexam.presentation.utils.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GnomeListFragment :
    BaseFragmentBinding<FragmentGnomeListBinding>(R.layout.fragment_gnome_list) {

    @Inject
    lateinit var factory: ViewModelFactory
    private val gnomeViewModel: GnomeViewModel by navGraphViewModels(R.id.nav_graph_xml) {
        factory
    }

    private val gnomeAdapter: GnomeAdapter by lazy {
        GnomeAdapter {
            navigateToDetail(it)
        }
    }

    private fun navigateToDetail(gnome: Gnome) {
        val action = GnomeListFragmentDirections.actionGnomeListFragmentToGnomeDetailFragment(
            gnome
        )
        findNavController().navigate(action)
    }

    override fun initComponent() {

        observe()

        gnomeViewModel.getGnomes()

        binding.recyclerGnome.apply {
            adapter = gnomeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

    private fun observe() {

        gnomeViewModel.gnomes.observe(viewLifecycleOwner, EventObserver { model ->

            if (model == BaseUiModel.Loading) loader.show() else loader.dismiss()

            when (model) {

                is BaseUiModel.Success -> {
                    manageSuccess(model.data)
                }
                is BaseUiModel.Error -> manageGnomeErrors(model.error)
                is BaseUiModel.ErrorEx -> manageGnomeErrors(getString(R.string.generic_error_message))
            }

        })

    }

    private fun manageSuccess(list: List<Gnome>) {
        gnomeAdapter.items = list
    }

    private fun manageGnomeErrors(error: String) {
        showErrorDialog(error)
    }

}