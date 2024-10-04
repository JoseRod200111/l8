package com.example.lab8

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Retrofit instance creation
private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")  // Base URL of the API
    .addConverterFactory(GsonConverterFactory.create())  // Use Gson for JSON to Kotlin object conversion
    .build()

// Creating the ApiService instance
val recipeService: ApiService = retrofit.create(ApiService::class.java)

// Interface defining the API endpoints
interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}

