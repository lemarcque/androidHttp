package io.capsulo.retrofittest.data

import com.google.gson.annotations.SerializedName

/**
 * Todo : Add class description
 */
data class User(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("address")
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)