package com.example.finger_licking.viewModel
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Interactor
import com.example.domain.models.Categories
import com.example.domain.models.Product
import com.example.domain.models.Tags
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductViewModel(val interactor: Interactor) : ViewModel() {

    fun getProduct() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                interactor.getProducts()
                    .collect { results ->
                        val productsList = mutableListOf<Product>()
                        if (results.data != null) {
                            productsList.addAll(results.data!!)
                        }
                        when {
                            results.message != null -> {
                                Log.d("myLog", results.message.toString())
                            }
                            productsList.isEmpty() -> {
                                Log.d("myLog", "Пустой список")
                            }
                        }

                    }
            }
        }
    }
    fun getCategories() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                interactor.getCategories()
                    .collect { results ->
                        val categoriesList = mutableListOf<Categories>()
                        if (results.data != null) {
                            categoriesList.addAll(results.data!!)
                        }
                        when {
                            results.message != null -> {
                                Log.d("myLog", results.message.toString())
                            }
                            categoriesList.isEmpty() -> {
                                Log.d("myLog", "Пустой список")
                            }
                        }

                    }
            }
        }
    }
    fun getTags() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                interactor.getTags()
                    .collect { results ->
                        val tagsList = mutableListOf<Tags>()
                        if (results.data != null) {
                            tagsList.addAll(results.data!!)
                        }
                        when {
                            results.message != null -> {
                                Log.d("myLog", results.message.toString())
                            }
                            tagsList.isEmpty() -> {
                                Log.d("myLog", "Пустой список")
                            }
                        }

                    }
            }
        }
    }
}