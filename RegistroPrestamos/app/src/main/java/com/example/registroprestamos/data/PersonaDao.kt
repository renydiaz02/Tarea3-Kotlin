package com.example.registroprestamos.data

import androidx.room.*
import com.example.registroprestamos.model.Personas
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(personas: Personas)

    @Delete
    suspend fun eliminar(personas: Personas)

    @Query("""
        SELECT *
        FROM Personas
        WHERE personaId = personaId
        
    """)
    fun buscar(personaId: Int): Flow<Personas>

    @Query("""
        SELECT *
        FROM Personas
        ORDER BY personaId
    """)
    fun getList(): Flow<List<Personas>>
}