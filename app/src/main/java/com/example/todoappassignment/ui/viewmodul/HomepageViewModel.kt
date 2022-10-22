package com.example.todoappassignment.ui.viewmodul

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoappassignment.data.entity.ToDoList
import com.example.todoappassignment.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(var tdrepo:ToDoRepository) : ViewModel() {
    var toDoLists = MutableLiveData<List<ToDoList>>()

    init {
        loadToDo()
    }

    fun loadToDo(){
        CoroutineScope(Dispatchers.Main).launch {
            toDoLists.value = tdrepo.loadToDo()
        }
    }

    fun search(searchWord:String){
        CoroutineScope(Dispatchers.Main).launch {
            toDoLists.value = tdrepo.search(searchWord)
        }
    }

    fun delete(toDoId:Int){
        CoroutineScope(Dispatchers.Main).launch {
            tdrepo.delete(toDoId)
            loadToDo()
        }
    }
}