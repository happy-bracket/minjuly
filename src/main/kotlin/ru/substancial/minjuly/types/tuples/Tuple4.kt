package ru.substancial.minjuly.types.tuples

data class Tuple4<A, B, C, D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
)

typealias Quadruple<A, B, C, D> = Tuple4<A, B, C, D>