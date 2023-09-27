package com.example.data.network

import com.example.data.dto.CategoriesResponce
import com.example.data.dto.ProductsResponce
import com.example.data.dto.models.CategoriesDto
import com.example.data.dto.models.TagsDto
import com.example.data.dto.models.TagsResponce
import retrofit2.http.GET

interface Api {
    @GET("products")
    suspend fun getProducts(): ProductsResponce

    @GET("categories")
    suspend fun getCategories(): CategoriesResponce

    @GET("tags")
    suspend fun getTags(): TagsResponce
}