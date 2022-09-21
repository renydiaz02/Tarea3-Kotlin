package com.example.registroprestamos.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Prestamos")
data class Prestamos(
    @PrimaryKey(autoGenerate = true)
    val prestamoId: Int =0,
    val fecha: String,
    val vence: String,
    val personaid: Int = 0,
    val concepto: String,
    val monto: Float,
    val balance: Float

 )
