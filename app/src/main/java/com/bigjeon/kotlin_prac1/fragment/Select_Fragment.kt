package com.bigjeon.kotlin_prac1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bigjeon.kotlin_prac1.R
import kotlinx.android.synthetic.main.fragment_select_.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Select_Fragment : Fragment(), View.OnClickListener{

    private var param1: String? = null
    private var param2: String? = null

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_select_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        previous_btn.setOnClickListener(this)
        Select_1.setOnClickListener(this)
        Select_2.setOnClickListener(this)
        Select_3.setOnClickListener(this)
        Select_4.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.Select_1 -> {navigateWithIndex(1)}
            R.id.Select_2 -> {navigateWithIndex(2)}
            R.id.Select_3 -> {navigateWithIndex(3)}
            R.id.Select_4 -> {navigateWithIndex(4)}
            R.id.previous_btn -> {
                navController.popBackStack()
            }
        }
    }

    fun navigateWithIndex(index : Int){

        val bundle = bundleOf("index" to index)

        navController.navigate(R.id.action_select_Fragment_to_result_Fragment, bundle)
    }
}