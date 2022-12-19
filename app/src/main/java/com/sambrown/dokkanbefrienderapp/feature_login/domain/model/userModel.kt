package com.sambrown.dokkanbefrienderapp.feature_login.domain.model

import com.google.gson.annotations.SerializedName

data class userModel(
    @SerializedName("id") val id: Int,
    val password: String,
    val idDokkan: Long,
    val dokkName: String
)