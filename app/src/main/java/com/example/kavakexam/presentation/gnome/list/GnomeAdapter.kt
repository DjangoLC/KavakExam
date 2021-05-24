package com.example.kavakexam.presentation.gnome.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kavakexam.core.domain.Gnome
import com.example.kavakexam.databinding.GnomeRowBinding
import kotlin.properties.Delegates

typealias onClickGnomeList = (Gnome) -> Unit

class GnomeAdapter(private val callback: onClickGnomeList) : RecyclerView.Adapter<ViewHolder>() {

    var items: List<Gnome> by Delegates.observable(emptyList(), { _, _, _ ->
        notifyDataSetChanged()
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.fromParent(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], callback)
    }

}

class ViewHolder(private val gnomeRowBinding: GnomeRowBinding) :
    RecyclerView.ViewHolder(gnomeRowBinding.root) {

    fun bind(gnome: Gnome, callback: onClickGnomeList) {
        gnomeRowBinding.gnome = gnome
        gnomeRowBinding.container.setOnClickListener {
            callback(gnome)
        }
        gnomeRowBinding.executePendingBindings()
    }

    companion object {
        fun fromParent(parent: ViewGroup): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return ViewHolder(GnomeRowBinding.inflate(inflater, parent, false))
        }
    }

}