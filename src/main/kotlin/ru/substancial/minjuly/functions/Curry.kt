package ru.substancial.minjuly.functions

fun <A1, A2, R> ((A1, A2) -> R).curry(): (A1) -> (A2) -> R =
    { a1 ->
        { a2 ->
            this(a1, a2)
        }
    }

fun <A1, A2, A3, R> ((A1, A2, A3) -> R).curry(): (A1) -> (A2) -> (A3) -> R =
    { a1 ->
        { a2 ->
            { a3 ->
                this(a1, a2, a3)
            }
        }
    }

fun <A1, A2, A3, A4, R> ((A1, A2, A3, A4) -> R).curry(): (A1) -> (A2) -> (A3) -> (A4) -> R =
    { a1 ->
        { a2 ->
            { a3 ->
                { a4 ->
                    this(a1, a2, a3, a4)
                }
            }
        }
    }