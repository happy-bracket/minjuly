package ru.substancial.minjuly.functions

fun <A, R> ((A) -> R).lazify(a: A): () -> R =
    {
        this(a)
    }

fun <A1, A2, R> ((A1, A2) -> R).lazify(a1: A1, a2: A2): () -> R =
    {
        this(a1, a2)
    }

fun <A1, A2, A3, R> ((A1, A2, A3) -> R).lazify(a1: A1, a2: A2, a3: A3): () -> R =
    {
        this(a1, a2, a3)
    }

fun <A1, A2, A3, A4, R> ((A1, A2, A3, A4) -> R).lazify(a1: A1, a2: A2, a3: A3, a4: A4): () -> R =
    {
        this(a1, a2, a3, a4)
    }