package com.sambrown.dokkanbefrienderapp.feature_friend_search.domain.model

import com.google.gson.annotations.SerializedName

data class cardModel(
    @SerializedName("id") val id: Int,
    val cardName: String,
    val awakenType: Char,
)