package com.corbettcode.myfavoritemovies.network.ktx

import com.corbettcode.myfavoritemovies.network.model.Result

val <T> Result<T>.nextPage: Int
    get() = page.plus(1)

val <T> Result<T>.isPaginationReached: Boolean
    get() = page == totalPages

val <T> Result<T>.isEmpty: Boolean
    get() = page == 1 && results.isEmpty()