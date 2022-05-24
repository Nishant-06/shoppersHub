package com.example.projectshoppingapp.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectshoppingapp.R
import com.example.projectshoppingapp.model.Person

class PersonListAdapter(private val list:ArrayList<Person>,private val context: Context):
    RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.list_row,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(person:Person){
            var item_name: TextView =itemView.findViewById(R.id.item_name_id) as TextView
            var amount: TextView =itemView.findViewById(R.id.amount_id) as TextView

            item_name.text=person.item_name
            amount.text=person.amount.toString()

        }

    }
}