package com.example.youtube.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.youtube.data.model.Item
import com.example.youtube.databinding.ActivityMainBinding
import com.example.youtube.ui.adapters.PlaylistAdapterItem
import com.example.youtube.ui.second.SecondActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class   MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private val adapterPlaylists by lazy { PlaylistAdapterItem(this::onClick) }

    private fun onClick(item: Item) {
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("key",item.id)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getPlaylists().observe(this){
            binding.rvPlaylists.adapter = adapterPlaylists
            adapterPlaylists.setList(it.items)
            adapterPlaylists.submitList(it.items)
        }
       /* viewModel.playlists.observe(this) {
            binding.rvPlaylists.adapter = adapterPlaylists
            adapterPlaylists.setList(it)
        }*/
    }
}