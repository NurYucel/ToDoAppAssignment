package com.example.todoappassignment.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "toDoList")
data class ToDoList(@PrimaryKey(autoGenerate = true)
                    @ColumnInfo(name = "toDoId") @NotNull var toDoId:Int,
                    @ColumnInfo(name = "toDo") @NotNull var toDo:String)
    : java.io.Serializable{

}