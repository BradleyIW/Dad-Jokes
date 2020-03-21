package com.bradley.wilson.jokes.core.network

import com.bradley.wilson.jokes.core.exceptions.ConnectionFailure
import com.bradley.wilson.jokes.core.exceptions.NetworkFailure
import com.bradley.wilson.jokes.core.functional.Either
import retrofit2.Response

abstract class ApiService {

    suspend fun <T> request(apiCall: suspend () -> Response<T>): Either<NetworkFailure, T> =
        Either.Left(ConnectionFailure)

}