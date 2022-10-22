package com.example.todoappassignment.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.todoappassignment.R
import com.example.todoappassignment.databinding.FragmentRecordBinding
import com.example.todoappassignment.ui.viewmodul.RecordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordFragment : Fragment() {

    private lateinit var design:FragmentRecordBinding
    private lateinit var viewModel: RecordViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_record, container, false)
        design.toDoRecordFragment = this
        design.toolbarToDoRecord.title = "Yapılacak İş Kayıt"

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:RecordViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSave(toDo:String){
        viewModel.save(toDo)
    }
}
