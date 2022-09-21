package com.example.registroprestamos.data

import androidx.room.*
import com.example.registroprestamos.model.Prestamos
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(prestamos: Prestamos)

    @Delete
    suspend fun eliminar(prestamos: Prestamos)

    @Query("""
        SELECT *
        FROM Prestamos
        WHERE prestamoId = prestamoId
    """)
    fun buscar(prestamoId: Int): Flow<Prestamos>

    @Query("""
        SELECT *
        FROM Prestamos
        ORDER BY prestamoId
    """)
    fun getList(): Flow<List<Prestamos>>
}