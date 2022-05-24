package com.example.projectshoppingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectshoppingapp.data.UserListAdapter
import kotlinx.android.synthetic.main.fragment_cart.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Cart.newInstance] factory method to
 * create an instance of this fragment.
 */
class Cart : Fragment() {
    private lateinit var helperData:MyDBHelper
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_cart, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addInfo(view)

        button.setOnClickListener{
            Toast.makeText(requireContext(), "Order Placed", Toast.LENGTH_SHORT).show()
        }



    }
    fun addInfo(v:View){
        attachAdapter(v)
    }

    private fun attachAdapter(v: View) {
        helperData= MyDBHelper(v.context)
        recyclerView2.layoutManager=LinearLayoutManager(v.context)
        recyclerView2.setHasFixedSize(true)
        val allData =helperData.listUser()
        if(allData.size>0){
            recyclerView2.visibility=View.VISIBLE
            val mAdapter = UserListAdapter(v.context,allData)
            recyclerView2.adapter=mAdapter
        }
        else{
            recyclerView2.visibility=View.GONE

        }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Cart.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Cart().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}