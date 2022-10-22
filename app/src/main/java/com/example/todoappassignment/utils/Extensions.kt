package com.example.todoappassignment.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.todoappassignment.R

fun Navigation.makePass(v: View, id:Int){
    findNavController(v).navigate(id)
}

fun Navigation.makePass(v: View, id:NavDirections){
    findNavController(v).navigate(id)
}
