package ru.substancial.minjuly.types.nullable

fun <A, R> lift(f: (A) -> R): (A?) -> R? =
    { a ->
        a?.let(f)
    }