package ru.substancial.minjuly.functions

fun <A, B, C> compose(f1: (A) -> B, f2: (B) -> C): (A) -> C =
    {
        f2(f1(it))
    }

infix fun <A, B, C> ((A) -> B).then(f: (B) -> C): (A) -> C =
    compose(this, f)

operator fun <A, B, C> ((A) -> B).invoke(f: (B) -> C): (A) -> C =
    compose(this, f)