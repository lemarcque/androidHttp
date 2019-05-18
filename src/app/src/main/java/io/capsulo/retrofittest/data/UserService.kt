package io.capsulo.retrofittest.data

import retrofit2.http.GET

/**
 * Todo : Add class description
 */
interface UserService {

    @GET("/users")
    fun getAllUsers() : retrofit2.Call<List<User>>
}