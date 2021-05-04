package com.kalugin19.passstore.util.passgenerator

enum class Mode(val symbolsSet: String) {
    ALPHABET("abcdefghijklmnopqrstuvwxyz"),
    DIGITS("0123456789"),
    PUNCTUATION("!@#$%&*()_+-=[]|,./?><");

    operator fun plus(mode: Mode): Array<Mode> {
        return arrayOf(this, mode)
    }

}