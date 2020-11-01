package com.mn9.mnotes3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mn9.mnotes3.R
import com.mn9.mnotes3.adapters.MyAdapter
import com.mn9.mnotes3.models.MainFragmentViewModel
import com.mn9.mnotes3.models.Note
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    private var myDataset = ArrayList<Note>()
    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view_main.adapter = MyAdapter(myDataset)
        recycler_view_main.layoutManager = LinearLayoutManager(context)
        recycler_view_main.setHasFixedSize(true)

        navController = Navigation.findNavController(view)
        view.findViewById<FloatingActionButton>(R.id.fab_main_frag).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.fab_main_frag -> navController.navigate(R.id.action_addNote)
        }

    }
}