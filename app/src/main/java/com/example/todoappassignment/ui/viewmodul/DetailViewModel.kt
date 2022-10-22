package com.example.todoappassignment.ui.viewmodul

import androidx.lifecycle.ViewModel
import com.example.todoappassignment.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var tdrepo:ToDoRepository): ViewModel() {

    fun update(toDoId:Int,toDo:String){
        CoroutineScope(Dispatchers.Main).launch {
            tdrepo.update(toDoId,toDo)
        }
    }
}