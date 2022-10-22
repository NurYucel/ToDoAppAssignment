package com.example.todoappassignment.room

import androidx.room.*
import com.example.todoappassignment.data.entity.ToDoList

@Dao
interface ToDoDao {
    @Query("SELECT * FROM toDoList")
    suspend fun loadToDo() : List<ToDoList>

    @Insert
    suspend fun save(toDo:ToDoList)

    @Update
    suspend fun update(toDo:ToDoList)

    @Delete
    suspend fun delete(toDo:ToDoList)

    @Query("SELECT * FROM toDoList WHERE toDo like'%' || :searchWord || '%'")
    suspend fun search(searchWord:String) : List<ToDoList>
}