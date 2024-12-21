package com.corbettcode.myfavoritemovies.network.model

import com.corbettcode.myfavoritemovies.network.model.Genre
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenresResponse(
    @SerialName("genres") val genres: List<Genre>
)