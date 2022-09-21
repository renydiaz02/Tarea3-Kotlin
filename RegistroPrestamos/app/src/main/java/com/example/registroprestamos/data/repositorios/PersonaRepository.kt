package com.example.registroprestamos.data.repositorios

import com.example.registroprestamos.data.PersonaDao
import com.example.registroprestamos.model.Personas
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonaRepository @Inject constructor(
    val personaDao: PersonaDao
) {
    suspend fun insertar(personas: Personas){
        personaDao.insertar(personas)
    }

    suspend fun eliminar(personas: Personas){
        personaDao.eliminar(personas)
    }

    fun buscar(personaId: Int): Flow<Personas>{
        return personaDao.buscar(personaId)
    }

    fun getList(): Flow<List<Personas>>{
        return personaDao.getList()
    }
}