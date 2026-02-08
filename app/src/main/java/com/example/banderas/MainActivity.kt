package com.example.banderas

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banderas.adapter.PaisesAdapter
import com.example.banderas.databinding.ActivityMainBinding
import com.example.banderas.retrofit.PaisesResponseItem
import com.example.banderas.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getListaPaises()

    }

    fun getListaPaises() {

        CoroutineScope(Dispatchers.IO).launch {

            try {

                val response = RetrofitClient.api.obtenerPaises()

                if (response.isSuccessful) {

                    val listaPaises = response.body() ?: listOf()

                    listaPaises.forEach { pais->
                        Log.i("paises", "getListaPaises: ${pais}")

                    }

                 runOnUiThread {

                     iniciarRecyclerPaises(listaPaises)

                 }


                } else {
                    Log.d("TAG", "Error response: ${response.errorBody()?.string()}")
                }

            } catch (e: Exception) {
                Log.d("TAG", "Error exception: ${e.message}")
            }

        }

    }

    fun iniciarRecyclerPaises(listaPaises: List<PaisesResponseItem>) {

        val adapter = PaisesAdapter(listaPaises)
        binding.rvPaises.adapter = adapter
        binding.rvPaises.layoutManager= LinearLayoutManager(this)

    }
}
