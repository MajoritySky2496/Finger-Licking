package com.example.data

import com.example.data.dto.Responce

interface NetworkClient {
    suspend fun getProducts(dto:Any):Responce

    suspend fun getCategories(dto:Any):Responce

    suspend fun getTags(dto: Any):Responce
}