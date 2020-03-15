package com.trinhlbk.core.utils

sealed class Result<T> {

    class Success<T>(val result: T) : Result<T>()

    class Fail<T>(val exception: Exception) : Result<T>() {
        constructor(message: String) : this(Exception(message))
    }

}
