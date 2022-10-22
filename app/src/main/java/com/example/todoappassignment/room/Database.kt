package com.example.todoappassignment.room

import androidx.room.RoomDatabase
import com.example.todoappassignment.data.entity.ToDoList


@androidx.room.Database(entities = [ToDoList::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getToDoDao() : ToDoDao
}