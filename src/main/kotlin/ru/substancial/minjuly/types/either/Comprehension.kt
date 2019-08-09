package ru.substancial.minjuly.types.either

import ru.substancial.minjuly.functions.id

class EitherComprehension<L> {

    var left: L? = null

    fun <T> Either<L, T>.bind(): T {
        return fold(
            {
                left = it
                throw Interrupt()
            },
            ::id
        )
    }

    class Interrupt : Exception()

}

fun <L, R> either(block: EitherComprehension<L>.() -> R): Either<L, R> {
    val context = EitherComprehension<L>()
    return try {
        context.block().let(::Right)
    } catch (e: EitherComprehension.Interrupt) {
        context.left!!.let(::Left)
    }
}