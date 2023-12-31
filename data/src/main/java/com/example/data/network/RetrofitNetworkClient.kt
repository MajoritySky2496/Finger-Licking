package com.example.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.data.NetworkClient
import com.example.data.dto.GetCategories
import com.example.data.dto.GetProductsRequest
import com.example.data.dto.GetTags
import com.example.data.dto.Responce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class RetrofitNetworkClient(private val api: Api, private val context: Context):NetworkClient {
    override suspend fun getProducts(dto: Any): Responce {
        if (isConnected() == false){
            return Responce().apply { resultCode = -1 }
        }
        if (dto !is GetProductsRequest){
            return Responce().apply { resultCode = 400 }
        }
        return withContext(Dispatchers.IO){
            try {
                val responce = Responce()
                val result = api.getProducts()
                responce.apply { resultCode = 200
                resultProducts = result}
            }catch (e:Throwable){
                Responce().apply { resultCode = 500 }
            }

        }
    }

    override suspend fun getCategories(dto: Any): Responce {
        if(isConnected() == false){
            return Responce().apply { resultCode = -1 }
        }
        if (dto !is GetCategories){
            return Responce().apply { resultCode = 400 }
        }
        return withContext(Dispatchers.IO){
            try {
                val responce = Responce()
                val result = api.getCategories()

                responce.apply { resultCode = 200
                resultCategories = result}
            }catch (e:Throwable){
                Responce().apply { resultCode = 500 }
            }
        }
    }

    override suspend fun getTags(dto: Any): Responce {
        if(isConnected() == false){
            return Responce().apply { resultCode = -1 }
        }
        if (dto !is GetTags ){
            Responce().apply { resultCode = -1 }
        }
         return withContext(Dispatchers.IO){
             try{
                 val result = api.getTags()
                val responce = Responce()
                responce.apply { resultCode = 200
                resultTags = result}
            }catch (e:Throwable){
                Responce().apply { resultCode = 500 }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
            }
        }
        return false
    }

}