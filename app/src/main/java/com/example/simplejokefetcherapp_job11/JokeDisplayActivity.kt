package com.example.simplejokefetcherapp_job11

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.simplejokefetcherapp_job11.databinding.ActivityJokeDisplayBinding

class JokeDisplayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJokeDisplayBinding
    private val viewModel: JokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_joke_display)

        binding.btnGetJoke.setOnClickListener {
            viewModel.fetchRandomJoke()
        }

        viewModel.joke.observe(this, Observer { joke ->
            joke?.let {
                binding.tvSetup.text = it.setup
                binding.tvPunchline.text = it.punchline
                binding.tvError.visibility = View.GONE
            } ?: run {
                binding.tvError.text = "Joke not available."
                binding.tvError.visibility = View.VISIBLE
            }
        })

        viewModel.errorMessage.observe(this, Observer { error ->
            error?.let {
                binding.tvError.text = it
                binding.tvError.visibility = android.view.View.VISIBLE
            }
        })
    }
}