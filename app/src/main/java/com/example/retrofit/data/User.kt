package com.example.retrofit.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("authentication_token")
    val authenticationToken: String,
    @SerializedName("persona")
    val person: Person
) {
    data class Person(
        @SerializedName("user_id")
        val userId: Int,
        @SerializedName("tipo_documento_id")
        val documentTypeId: Int,
        @SerializedName("documento")
        val document: String,
        @SerializedName("fecha_nacimiento")
        val birthDate: String
    )

    override fun toString(): String {
        return this.name
    }
}