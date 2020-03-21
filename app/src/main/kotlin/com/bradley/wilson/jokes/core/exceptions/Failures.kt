package com.bradley.wilson.jokes.core.exceptions

sealed class Failure

sealed class NetworkFailure : Failure()
object ConnectionFailure : NetworkFailure()
object ServerError : NetworkFailure()
object BadRequest : NetworkFailure()
object Unauthorized : NetworkFailure()
object Forbidden : NetworkFailure()
object NotFound : NetworkFailure()
object Cancelled : NetworkFailure()
object InternalServerError : NetworkFailure()
object Conflict : NetworkFailure()
object EmptyResponseBody : NetworkFailure()

sealed class DatabaseFailure : Failure()

// Use this class for feature level failures upstream.
abstract class FeatureFailure : Failure()
