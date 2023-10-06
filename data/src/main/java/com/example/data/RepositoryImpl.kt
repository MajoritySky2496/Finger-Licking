package com.example.data
import com.example.data.dto.GetCategories
import com.example.data.dto.GetProductsRequest
import com.example.data.dto.GetTags
import com.example.data.util.mapCategoryFromDto
import com.example.data.util.mapProductFromDto
import com.example.data.util.mapTagFromDto
import com.example.domain.Repository
import com.example.domain.models.Categories
import com.example.domain.models.Product
import com.example.domain.models.Tags
import com.example.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(private val networkClient: NetworkClient, ):Repository {

    override suspend fun getProducts(): Flow<Resource<List<Product>>> = flow {
        val response = networkClient.getProducts(GetProductsRequest)
        when (response.resultCode) {
            ERROR -> {
                emit(Resource.Error("Check"))
            }

            SUCCESS -> {
                with(response) {
                    val productList = response.resultProducts.map { mapProductFromDto(it) }
                    emit(Resource.Success(productList))
                }
            }

            else -> {
                emit(Resource.Error("Ошибка Сервера"))
            }
        }

    }

    override suspend fun getCategories(): Flow<Resource<List<Categories>>> = flow {
        val response = networkClient.getCategories(GetCategories)
        when (response.resultCode) {
            ERROR -> {
                emit(Resource.Error("Check"))
            }

            SUCCESS -> {
                with(response) {
                    val categoriesList = response.resultCategories.map { mapCategoryFromDto(it) }
                    emit(Resource.Success(categoriesList))
                }
            }

            else -> {
                emit(Resource.Error("Ошибка Сервера"))
            }
        }
    }

    override suspend fun getTags(): Flow<Resource<List<Tags>>> = flow{
        val response = networkClient.getTags(GetTags)
        when (response.resultCode) {
            ERROR -> {
                emit(Resource.Error("Check"))
            }

            SUCCESS -> {
                with(response) {
                    val tagsList = response.resultTags.map { mapTagFromDto(it)  }
                    emit(Resource.Success(tagsList))
                }
            }

            else -> {
                emit(Resource.Error("Ошибка Сервера"))
            }
        }
    }


    companion object {
        const val ERROR = -1
        const val SUCCESS = 200
    }
}