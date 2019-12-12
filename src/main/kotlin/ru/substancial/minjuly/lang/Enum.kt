package ru.substancial.minjuly.lang

inline fun <reified E : Enum<E>> enumNames(): List<String> {
    return enumValues<E>().map { it.name }
}