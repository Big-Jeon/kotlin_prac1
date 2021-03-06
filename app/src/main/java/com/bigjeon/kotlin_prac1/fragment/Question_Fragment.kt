package com.bigjeon.kotlin_prac1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bigjeon.kotlin_prac1.R
import kotlinx.android.synthetic.main.fragment_main_.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Question_Fragment : Fragment(), View.OnClickListener{

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
        return inflater.inflate(R.layout.fragment_question_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        next_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.next_btn -> {
                navController.navigate(R.id.action_question_Fragment_to_select_Fragment)
            }
        }
    }
}