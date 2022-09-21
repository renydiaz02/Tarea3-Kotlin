package com.example.registroprestamos.data.repositorios

import com.example.registroprestamos.data.PrestamoDao
import com.example.registroprestamos.model.Prestamos
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrestamosRepository @Inject constructor(
    val prestamoDao: PrestamoDao
) {
    suspend fun  insertar(prestamos: Prestamos){
        prestamoDao.insertar(prestamos)
    }

    suspend fun eliminar(prestamos: Prestamos){
        prestamoDao.eliminar(prestamos)
    }

    fun buscar(prestamosId: Int): Flow<Prestamos>{
        return prestamoDao.buscar(prestamosId)
    }

    fun getList(): Flow<List<Prestamos>>{
        return prestamoDao.getList()
    }
}