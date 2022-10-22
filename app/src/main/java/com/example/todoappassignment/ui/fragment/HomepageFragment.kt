package com.example.todoappassignment.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoappassignment.R
import com.example.todoappassignment.data.entity.ToDoList
import com.example.todoappassignment.databinding.FragmentHomepageBinding
import com.example.todoappassignment.ui.adapter.ToDoAdapter
import com.example.todoappassignment.ui.viewmodul.HomepageViewModel
import com.example.todoappassignment.ui.viewmodul.RecordViewModel
import com.example.todoappassignment.utils.makePass
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var design:FragmentHomepageBinding
    private lateinit var viewModel: HomepageViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        design = DataBindingUtil.inflate(inflater,R.layout.fragment_homepage, container, false)
        design.homepageFragment = this

        design.homepageToolbarTitle = "Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarHomepage)

        viewModel.toDoLists.observe(viewLifecycleOwner){
            val adapter = ToDoAdapter(requireContext(),it,viewModel)
            design.toDoAdapter = adapter
        }

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomepageFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner,Lifecycle.State.RESUMED)

        return design.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomepageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabClick(view:View){
        Navigation.makePass(view,R.id.recordPass)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadToDo()
    }

}