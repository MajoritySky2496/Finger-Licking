package com.example.data.network

import com.example.data.dto.models.CategoriesDto
import com.example.data.dto.models.ProductsDto
import com.example.data.dto.models.TagsDto
import retrofit2.http.GET

interface Api {
    @GET("/v3/012acae8-7ef6-43a4-ba41-f609abd12551")
    suspend fun getProducts(): List<ProductsDto>

    @GET("/v3/3fc50273-c787-4c54-9c6f-97449b3c74c3")
    suspend fun getCategories(): List<CategoriesDto>

    @GET("/v3/33ff0347-ac71-48c5-89ef-7134ddeb3ad5")
    suspend fun getTags(): List<TagsDto>
}