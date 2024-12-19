package com.corbettcode.myfavoritemovies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform