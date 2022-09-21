package com.example.registroprestamos.di

import android.content.Context
import androidx.room.Room
import com.example.registroprestamos.data.PersonaDao
import com.example.registroprestamos.data.PrestamoDao
import com.example.registroprestamos.data.PrestamosDb
import com.example.registroprestamos.data.repositorios.PersonaRepository
import com.example.registroprestamos.data.repositorios.PrestamosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun ProvideTicketDb(@ApplicationContext context: Context): PrestamosDb{
        val  DATABASE_NAME = "PrestamosDb"
        return  Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvidePersonaDao(prestamosDb: PrestamosDb): PersonaDao{
        return prestamosDb.personaDao
    }

    @Provides
    fun ProvidePrestamoDao(prestamosDb: PrestamosDb): PrestamoDao{
        return prestamosDb.prestamoDao
    }

    @Provides
    fun providePrestamosRepository(prestamoDao: PrestamoDao): PrestamosRepository{
        return PrestamosRepository(prestamoDao)
    }

    @Provides
    fun providePersonaRepository(personaDao: PersonaDao):PersonaRepository{
        return PersonaRepository(personaDao)
    }
}