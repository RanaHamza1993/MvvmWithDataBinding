package com.hamza.mvvmwithdatabinding.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val URL="http://10.0.2.2:9000/"
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okhttpBuilder=OkHttpClient.Builder().addInterceptor(logger)
    private val retrofit=Retrofit.Builder() .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttpBuilder.build())
        .build()
    operator fun<T> invoke(service:Class<T>):T{
        return retrofit.create(service)
    }
}