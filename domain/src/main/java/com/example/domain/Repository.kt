package com.example.domain

import com.example.domain.models.Categories
import com.example.domain.models.Product
import com.example.domain.models.Tags
import com.example.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
     suspend fun getProducts(): Flow<Resource<List<Product>>>
     suspend fun getCategories(): Flow<Resource<List<Categories>>>

     suspend fun getTags(): Flow<Resource<List<Tags>>>

}