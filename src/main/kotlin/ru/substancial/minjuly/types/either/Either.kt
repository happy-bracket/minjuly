package ru.substancial.minjuly.types.either

import ru.substancial.minjuly.functions.then

sealed class Either<out L, out R> {

    data class Left<L>(val value: L) : Either<L, Nothing>()
    data class Right<R>(val value: R) : Either<Nothing, R>()

    fun <C> fold(ifLeft: (L) -> C, ifRight: (R) -> C): C =
        when (this) {
            is Left -> ifLeft(value)
            is Right -> ifRight(value)
        }

}

fun <L> Left(value: L): Either<L, Nothing> = Either.Left(value)
fun <R> Right(value: R): Either<Nothing, R> = Either.Right(value)

fun <L, A, R> lift(f: (A) -> R): (Either<L, A>) -> Either<L, R> =
    { e ->
        e.fold(
            ::Left,
            f then ::Right
        )
    }

fun <L, R1, R2> Either<L, R1>.map(f: (R1) -> (R2)): Either<L, R2> =
    lift<L, R1, R2>(f)(this)

fun <L, R1, R2> Either<L, R1>.flatMap(f: (R1) -> Either<L, R2>): Either<L, R2> =
    fold(::Left, f)