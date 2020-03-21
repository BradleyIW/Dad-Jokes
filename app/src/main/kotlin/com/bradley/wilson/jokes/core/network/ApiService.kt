package com.bradley.wilson.jokes.core.network

import com.bradley.wilson.jokes.core.exceptions.NetworkFailure
import com.bradley.wilson.jokes.core.functional.Either
import retrofit2.Response

class ApiService {

    suspend fun <T> request(apiCall: suspend () -> Response<T>): Either<NetworkFailure, T> =
        Either.Right(apiCall.invoke().body()!!)

}