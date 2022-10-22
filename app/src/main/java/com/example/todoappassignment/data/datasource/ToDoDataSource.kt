package com.example.todoappassignment.data.datasource

import com.example.todoappassignment.data.entity.ToDoList
import com.example.todoappassignment.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource (var tddao:ToDoDao){

    suspend fun save(toDo:String){
        val newToDo = ToDoList(0,toDo)
        tddao.save(newToDo)
    }

    suspend fun update(toDoId:Int,toDo:String){
        val updateToDo = ToDoList(toDoId,toDo)
        tddao.update(updateToDo)
    }

    suspend fun loadToDo() : List<ToDoList> =
        withContext(Dispatchers.IO){
            tddao.loadToDo()
        }

    suspend fun search(searchWord:String) : List<ToDoList> =
        withContext(Dispatchers.IO){
            tddao.search(searchWord)
        }

    suspend fun delete(toDoId:Int){
        val deleteToDo = ToDoList(toDoId,"")
        tddao.delete(deleteToDo)
    }
}