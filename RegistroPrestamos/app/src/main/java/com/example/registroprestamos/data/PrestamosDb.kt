package com.example.registroprestamos.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.registroprestamos.model.Personas
import com.example.registroprestamos.model.Prestamos

@Database(
    entities = [
        Prestamos::class,
        Personas::class
    ],
    exportSchema = false,
    version = 1
)
abstract class PrestamosDb : RoomDatabase() {
    abstract  val prestamoDao: PrestamoDao
    abstract val personaDao: PersonaDao
}