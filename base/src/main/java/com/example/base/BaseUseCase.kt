package com.example.base

abstract class BaseUseCase<out Result, in Params> {

    abstract suspend fun run(params: Params , onResult: (result: UseCaseResult) -> Unit)

}

sealed class UseCaseResult {

    data class Success<T : Any>(val response: T) : UseCaseResult()

    object Failure : UseCaseResult()
}

class None