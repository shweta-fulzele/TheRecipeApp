package com.base.therecipeapp.domain.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitClient {

    companion object {

        private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val recipeService = retrofit.create(ApiService::class.java)

    }

}