package com.albertoOlle.ejercicioclase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.albertoOlle.ejercicioclase.adapter.UserAdapter
import com.albertoOlle.ejercicioclase.data.FakeData
import com.albertoOlle.ejercicioclase.data.RepositoryJson
import com.albertoOlle.ejercicioclase.databinding.ActivityMainBinding
import com.albertoOlle.ejercicioclase.model.toRepositories

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity", "Inicia")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = GsonBuilder().create()
        val result = gson.fromJson(FakeData.repositoriesJson, Array<RepositoryJson>::class.java)

        (application as App).users.addAll(result.map { it.toRepositories() })

        val repositories = (application as App).users
        adapter = UserAdapter(repositories) { repository ->
            val intent = Intent(this, viewRepository::class.java)
            intent.putExtra("userId", repository.id)
            startActivity(intent)
        }
        binding.repositoryListReclycler.adapter = adapter
        binding.repositoryListReclycler.layoutManager = LinearLayoutManager(this)
        binding.repositoryListReclycler.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

    }
}
