package com.example.projectshoppingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectshoppingapp.data.MyAdapter
import com.example.projectshoppingapp.data.PersonListAdapter
import com.example.projectshoppingapp.model.Model
import com.example.projectshoppingapp.model.Person
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var adapter: PersonListAdapter?=null
    private var personList: ArrayList<Person>?=null
    private var layoutManager: RecyclerView.LayoutManager?=null
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
        val v= inflater.inflate(R.layout.fragment_home, container, false)
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayList = ArrayList<Model>()
        arrayList.add(Model("Bread", "Gluten Free Bread","$5",R.drawable.bread_01))
        arrayList.add(Model("Cake", "Vanilla Flavoured Cake","$50",R.drawable.cake))
        arrayList.add(Model("Pizza", "Peperoni Pizza","$15",R.drawable.pizza))

        val myAdapter = MyAdapter(arrayList, this.requireContext())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter=myAdapter
//        personList=ArrayList<Person>()
//        layoutManager= LinearLayoutManager(this.context)
//        adapter= this.context?.let { PersonListAdapter(personList!!, it) }
//
//        //setup list (recyclerview)
//        recyclerView.layoutManager=layoutManager
//        recyclerView.adapter=adapter
//
//
//        //load data recycler view
//        for (i in 0..10){
//            val person=Person()
//            person.item_name="item"+i
//            person.amount=20+i
//            personList!!.add(person)
//        }
//        adapter!!.notifyDataSetChanged()

    }

    override fun onStart() {
        super.onStart()
    }
}