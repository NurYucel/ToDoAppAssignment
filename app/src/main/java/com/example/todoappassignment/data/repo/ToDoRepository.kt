package com.example.todoappassignment.data.repo

import com.example.todoappassignment.data.datasource.ToDoDataSource
import com.example.todoappassignment.data.entity.ToDoList

class ToDoRepository(var tdds:ToDoDataSource) {


    suspend fun save(toDo:String) = tdds.save(toDo)

    suspend fun update(toDoId:Int,toDo:String)= tdds.update(toDoId,toDo)

    suspend fun loadToDo() : List<ToDoList> = tdds.loadToDo()

    suspend fun search(searchWord:String) : List<ToDoList> = tdds.search(searchWord)

    suspend fun delete(toDoId:Int) = tdds.delete(toDoId)
}