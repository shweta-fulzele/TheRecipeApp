package com.base.therecipeapp.domain.retrofit


import com.base.therecipeapp.data.models.CategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



interface ApiService{
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

}