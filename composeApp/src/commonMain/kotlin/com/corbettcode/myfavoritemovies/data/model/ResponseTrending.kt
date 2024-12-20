package com.corbettcode.myfavoritemovies.data.model


import com.corbettcode.myfavoritemovies.domain.model.Result
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ResponseTrending(
    @SerialName("page")
    val page: Int?,
    @SerialName("results")
    val results: List<Result?>?,
    @SerialName("total_pages")
    val totalPages: Int?,
    @SerialName("total_results")
    val totalResults: Int?
)