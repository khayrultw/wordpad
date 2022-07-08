package com.khayrultw.wordpad.data.apis.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception

@Entity
data class Word(
    @PrimaryKey
    val id: Int? = null,
    val title: String,
    val meaning: String,
    val details: String,
    val status: String,
    val date: Long
)

class InvalidWordException(message: String) : Exception(message)
