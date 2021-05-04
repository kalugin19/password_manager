package com.kalugin19.passstore.util.passgenerator


interface PasswordGenerator {
    suspend fun generate(count: Int, modes: Array<Mode>) : String
}

