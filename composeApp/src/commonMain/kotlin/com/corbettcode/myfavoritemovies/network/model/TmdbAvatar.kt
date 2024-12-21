package com.corbettcode.myfavoritemovies.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TmdbAvatar(
    @SerialName("avatar_path") val avatarPath: String
)