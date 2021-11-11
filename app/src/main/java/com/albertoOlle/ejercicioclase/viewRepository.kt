package com.albertoOlle.ejercicioclase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.albertoOlle.ejercicioclase.databinding.RepositoryItemBinding

class viewRepository : AppCompatActivity() {
    private lateinit var binding:RepositoryItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RepositoryItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var tags = ""
        val repositoryId = intent.getIntExtra("userId", -1)
        val repository = (application as App).users.first { it.id == repositoryId }
        if (repository.topics.isEmpty()){
            tags = "No tags"
        }else {
            for (index in repository.topics.indices) {
                tags += " #${repository.topics.get(index)}"
            }
        }
        binding.repositoryNameData.text = "${repository.name}"
        binding.repositoryDescriptionData.text = "${repository.description}"
        binding.repositoryOwnerData.text = "${repository.login}"
        binding.repositoryLanguagesData.text = "${repository.language}"
        binding.repositoryLicenseData.text = "${repository.license}"
        binding.repositoryTagsData.text = tags
        Picasso.get()
            .load(repository.picture)
            .placeholder(R.mipmap.ic_launcher)
            .into(binding.repositoryUserImage)

    }
}