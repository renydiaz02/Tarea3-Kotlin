package com.example.registroprestamos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Personas")
data class Personas(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int = 0,
    val nombres: String,
    val email: String,
    val balance: Float
)
