package com.example.domain

import com.example.domain.models.Categories
import com.example.domain.models.Product
import com.example.domain.models.Tags
import com.example.domain.util.Results
import kotlinx.coroutines.flow.Flow

interface Interactor {
    suspend fun getProducts(): Flow<Results<List<Product>?, String?>>

    suspend fun getCategories():Flow<Results<List<Categories>?, String?>>

    suspend fun getTags():Flow<Results<List<Tags>?, String?>>
}