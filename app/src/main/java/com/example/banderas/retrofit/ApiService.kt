package com.example.banderas.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface  ApiService {

    @GET("all?fields=name,flags,languages")
    suspend fun obtenerPaises():Response<List<PaisesResponseItem>>


}