package ru.substancial.minjuly.types.nullable

class NullableComprehension {

    fun <T> T?.bind(): T =
            this ?: throw Interrupt()

    class Interrupt : Exception()

}

fun <R> nullable(block: NullableComprehension.() -> R): R? {
    val context = NullableComprehension()
    return try {
        context.block()
    } catch (e: NullableComprehension.Interrupt) {
        null
    }
}