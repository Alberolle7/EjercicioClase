package com.albertoOlle.ejercicioclase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.albertoOlle.ejercicioclase.R
import com.albertoOlle.ejercicioclase.model.Repository
import com.albertoOlle.ejercicioclase.databinding.RepositoryListBinding
import com.squareup.picasso.Picasso



class UserAdapter(
    private val dataset: List<Repository>,
    private val listener: (Repository) -> Unit):RecyclerView.Adapter<UserAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RepositoryListBinding = RepositoryListBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.binding.repositoryName.text = item.name
        holder.binding.repositoryDescription.text = item.description
        Picasso.get()
            .load(item.picture)
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.binding.repositoryImage)
        holder.binding.root.setOnClickListener { listener(item) }
    }


    override fun getItemCount(): Int {
        return dataset.size
    }
    class ItemViewHolder(val binding: RepositoryListBinding) : RecyclerView.ViewHolder(binding.root)
}
