package com.kalugin19.passstore.util.passgenerator

import java.util.*
import javax.inject.Inject
import kotlin.math.abs

class PasswordGeneratorImpl @Inject constructor() : PasswordGenerator {

    private val needUppercase: Boolean
        get() = listOf(true, false).shuffled().first()

    override suspend fun generate(count: Int, modes: Array<Mode>): String {
        val firstPart = modes.map {
            it.symbolsSet
                .toMutableList()
                .shuffled()
                .first()
        }.fold(StringBuilder()) { acc, c ->
            acc.append(c)
        }

        val set = modes.fold(StringBuilder()) { acc, mode ->
            acc.append(mode.symbolsSet)
        }.toString()

        val size = abs(count - firstPart.length - 1)

        val secondPart = (0..size).fold(StringBuilder()) { acc, _ ->
            val symbol = when (needUppercase) {
                true -> set.toUpperCase(Locale.getDefault())
                else -> set.toLowerCase(Locale.getDefault())
            }.toMutableList().shuffled().first()

            acc.append(symbol)
        }

        return firstPart.append(secondPart)
            .toString()
            .toMutableList()
            .shuffled()
            .joinToString(separator = "")
    }

}