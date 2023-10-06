package com.example.domain.impl


import com.example.domain.Interactor
import com.example.domain.Repository
import com.example.domain.models.Categories
import com.example.domain.models.Product
import com.example.domain.models.Tags
import com.example.domain.util.Resource
import com.example.domain.util.Results
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*

class InteractorImpl(val repository: Repository):Interactor {
    override suspend fun getProducts(): Flow<Results<List<Product>?, String?>> {
        return repository.getProducts().map { result ->
            when(result){
                is Resource.Success -> {
                    Results(result.data, null)
                }
                is Resource.Error -> {
                    Results(null, result.message
                    )
                }
            }

        }
    }

    override suspend fun getCategories(): Flow<Results<List<Categories>?, String?>> {
        return repository.getCategories().map { result ->
            when(result){
                is Resource.Success -> {
                    Results(result.data, null)
                }
                is Resource.Error -> {
                    Results(null, result.message
                    )
                }
            }
        }
    }

    override suspend fun getTags(): Flow<Results<List<Tags>?, String?>> {
        return repository.getTags().map { result ->
            when(result){
                is Resource.Success -> {
                    Results(result.data, null)
                }
                is Resource.Error -> {
                    Results(null, result.message
                    )
                }
            }
        }
    }


}