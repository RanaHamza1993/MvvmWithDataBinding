package com.hamza.mvvmwithdatabinding.utils

import retrofit2.Response

abstract class SafeApiRequest {

    suspend fun<T:Any> apiRequest(call:suspend ()->Response<T>):T{
        val respose=call.invoke()
        if(respose.isSuccessful)
            return respose.body()!!
        else{
            throw ApiException(respose.errorBody().toString())
        }
    }
}