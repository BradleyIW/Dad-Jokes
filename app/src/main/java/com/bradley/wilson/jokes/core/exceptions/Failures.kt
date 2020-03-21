package com.bradley.wilson.jokes.core.exceptions

sealed class Failure

sealed class NetworkFailure : Failure()
object ConnectionFailure : NetworkFailure()

sealed class DatabaseFailure : Failure()

// Use this class for feature level failures upstream.
abstract class FeatureFailure : Failure()
