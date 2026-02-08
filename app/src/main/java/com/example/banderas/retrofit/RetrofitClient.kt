package com.example.banderas.retrofit

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
object RetrofitClient
{

  val api: ApiService by lazy {

      Retrofit.Builder()
          .baseUrl("https://restcountries.com/v3.1/")
          .addConverterFactory(GsonConverterFactory.create())
          .build()
          .create(ApiService::class.java)

  }


}