package com.example.todoappassignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoappassignment.R
import com.example.todoappassignment.data.entity.ToDoList
import com.example.todoappassignment.databinding.CardDesignBinding
import com.example.todoappassignment.databinding.FragmentHomepageBinding
import com.example.todoappassignment.ui.fragment.HomepageFragment
import com.example.todoappassignment.ui.fragment.HomepageFragmentDirections
import com.example.todoappassignment.ui.viewmodul.HomepageViewModel
import com.example.todoappassignment.utils.makePass
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(var mContext:Context,
                  var toDoLists:List<ToDoList>,
                  var viewModel: HomepageViewModel) :
    RecyclerView.Adapter<ToDoAdapter.CardDesignCatch>() {
    inner class CardDesignCatch(design: CardDesignBinding) : RecyclerView.ViewHolder(design.root){
        var design:CardDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignCatch {
        val design:CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.card_design, parent, false)
        return  CardDesignCatch(design)
    }

    override fun onBindViewHolder(holder: CardDesignCatch, position: Int) {
        val toDo = toDoLists.get(position)
        val d = holder.design
        d.toDoObject = toDo

        d.cardLine.setOnClickListener {
            val pass = HomepageFragmentDirections.detailPass(toDo = toDo)
            Navigation.makePass(it,pass)
        }
        d.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${toDo.toDo} silinsin mi?",Snackbar.LENGTH_LONG).setAction("Evet"){
                viewModel.delete(toDo.toDoId)
            }.show()
        }
    }

    override fun getItemCount(): Int {
        return toDoLists.size
    }
}