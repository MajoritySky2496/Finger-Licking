package com.example.finger_licking.di

import com.example.data.NetworkClient
import com.example.data.network.Api
import com.example.data.network.RetrofitNetworkClient
import okhttp3.mockwebserver.MockWebServer
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {
    single { MockWebServer() }
    single<Api> {
        val server: MockWebServer = get()
        val url = server.url("/")
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
    single<NetworkClient> { RetrofitNetworkClient(get(), get())  }
}


