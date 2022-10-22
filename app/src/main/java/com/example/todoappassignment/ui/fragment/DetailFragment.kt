package com.example.todoappassignment.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoappassignment.R
import com.example.todoappassignment.databinding.FragmentDetailBinding
import com.example.todoappassignment.ui.viewmodul.DetailViewModel
import com.example.todoappassignment.ui.viewmodul.RecordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var design:FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)
        design.toDoDetailToolbarTitle = "Yapılacak İş Detay"

        val bundle:DetailFragmentArgs by navArgs()
        val incomingToDo = bundle.toDo

        design.toDoObject = incomingToDo

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonUpdate(toDoId:Int,toDo:String){
        viewModel.update(toDoId,toDo)
    }
}