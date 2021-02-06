package io.moatwel.playground.edwardssample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.moatwel.crypto.eddsa.Edwards
import io.moatwel.playground.edwardssample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val edwards = Edwards()

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val GENERATE_COUNT = 10000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.root.handler.post {
                val start = System.currentTimeMillis()

                (1..GENERATE_COUNT).forEach { _ ->
                    Log.d("Edwards", edwards.generateKeyPair().publicKey.hexString)
                }

                val end = System.currentTimeMillis()

                Log.d("Edwards", "Time: ${(end - start) / GENERATE_COUNT} ms")
            }
        }
    }
}