package com.corbettcode.myfavoritemovies.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ResponseDiscover(
    @SerialName("page")
    val page: Int?,
    @SerialName("results")
    val results: List<Result?>?,
    @SerialName("total_pages")
    val totalPages: Int?,
    @SerialName("total_results")
    val totalResults: Int?
)