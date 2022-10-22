package com.example.todoappassignment.di

import android.content.Context
import androidx.room.Room
import com.example.todoappassignment.data.datasource.ToDoDataSource
import com.example.todoappassignment.data.repo.ToDoRepository
import com.example.todoappassignment.room.Database
import com.example.todoappassignment.room.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDoRepository(tdds:ToDoDataSource) : ToDoRepository{
        return ToDoRepository(tdds)
    }
    @Provides
    @Singleton
    fun provideToDoDataSource(tddao:ToDoDao) : ToDoDataSource{
        return ToDoDataSource(tddao)
    }
    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context:Context) : ToDoDao{
        val db = Room.databaseBuilder(context,Database::class.java,"tododb.sqlite")
            .createFromAsset("tododb.sqlite").build()

        return db.getToDoDao()
    }


}