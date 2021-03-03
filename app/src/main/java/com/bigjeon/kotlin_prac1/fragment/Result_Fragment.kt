package com.bigjeon.kotlin_prac1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bigjeon.kotlin_prac1.R
import kotlinx.android.synthetic.main.fragment_result_.*
import kotlinx.android.synthetic.main.fragment_select_.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Result_Fragment : Fragment(){

    private var param1: String? = null
    private var param2: String? = null

    var Select = -1
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

        Select = arguments?.getInt("index")?: -1
        return inflater.inflate(R.layout.fragment_result_, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        setResult(Select)

        home_btn.setOnClickListener{
            navController.navigate(R.id.action_result_Fragment_to_main_Fragment)
        }
    }

    private fun setResult(Select: Int) {
        when(Select){
            1 -> {
                Result_Num.text = "1번 결과입니다."
                Result_Text.text = "냉혈적입니다."
            }
            2 -> {
                Result_Num.text = "2번 결과입니다."
                Result_Text.text = "온화적입니다."
            }
            3 -> {
                Result_Num.text = "3번 결과입니다."
                Result_Text.text = "독신주의입니다."
            }
            4 -> {
                Result_Num.text = "4번 결과입니다."
                Result_Text.text = "소심적입니다."
            }
        }
    }
}