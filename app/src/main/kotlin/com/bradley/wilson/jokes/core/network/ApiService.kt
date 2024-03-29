package com.bradley.wilson.jokes.core.network

import com.bradley.wilson.jokes.core.exceptions.*
import com.bradley.wilson.jokes.core.functional.Either
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class ApiService {
    abstract val networkHandler: NetworkHandler

    suspend fun <T> request(
        default: T? = null,
        call: suspend () -> Response<T>
    ): Either<Failure, T> =
        withContext(Dispatchers.IO) {
            return@withContext when (networkHandler.isConnected) {
                true -> performRequest(call, default)
                false, null -> Either.Left(ConnectionFailure)
            }
        }

    private suspend fun <T> performRequest(
        call: suspend () -> Response<T>,
        default: T? = null
    ): Either<Failure, T> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                response.body()?.let { Either.Right(it) }
                    ?: (default?.let { Either.Right(it) } ?: Either.Left(EmptyResponseBody))
            } else {
                handleRequestError(response)
            }
        } catch (exception: Exception) {
            when (exception) {
                is CancellationException -> Either.Left(Cancelled)
                else -> Either.Left(ServerError)
            }
        }
    }

    private fun <T> handleRequestError(response: Response<T>): Either<Failure, T> =
        when (response.code()) {
            CODE_BAD_REQUEST -> Either.Left(BadRequest)
            CODE_UNAUTHORIZED -> Either.Left(Unauthorized)
            CODE_FORBIDDEN -> Either.Left(Forbidden)
            CODE_NOT_FOUND -> Either.Left(NotFound)
            CODE_CONFLICT -> Either.Left(Conflict)
            CODE_INTERNAL_SERVER_ERROR -> Either.Left(InternalServerError)
            else -> Either.Left(ServerError)
        }

    companion object {
        private const val CODE_BAD_REQUEST = 400
        private const val CODE_UNAUTHORIZED = 401
        private const val CODE_FORBIDDEN = 403
        private const val CODE_NOT_FOUND = 404
        private const val CODE_CONFLICT = 409
        private const val CODE_INTERNAL_SERVER_ERROR = 500
    }
}
