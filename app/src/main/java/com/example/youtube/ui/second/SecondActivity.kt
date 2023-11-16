package com.example.youtube.ui.second

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.youtube.data.model.Item
import com.example.youtube.databinding.ActivitySecondBinding
import com.example.youtube.ui.adapters.PlaylistAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val vm :SecondViewModel by viewModel()
    private val adapter by lazy { PlaylistAdapter(this::OnClick) }

    private fun OnClick(item: Item) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result = intent.getStringExtra("key")
        result?.let {
            vm.getPlaylistsItem(it).observe(this) {
                binding.rv.adapter = adapter
                adapter.setList(it.items)
            }
        }
    }
}