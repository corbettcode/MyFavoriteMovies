package com.corbettcode.myfavoritemovies.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeletedSession(
    @SerialName("success") val success: Boolean
)