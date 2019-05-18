package io.capsulo.retrofittest.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Todo : Add class description
 */

object RetrofitImpl {

        var _instance :Retrofit? = null
        val BASE_URL: String = "https://jsonplaceholder.typicode.com"

        fun getInstance() :Retrofit? {
            if(_instance == null) {
                _instance = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return _instance
        }
}