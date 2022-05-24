package com.example.projectshoppingapp.data

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectshoppingapp.AnotherActivity
import com.example.projectshoppingapp.R
import com.example.projectshoppingapp.model.Model
import kotlinx.android.synthetic.main.card_layout.view.*

class MyAdapter(val arrayList : ArrayList<Model>, val context : Context)
    : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun binditems(model:Model){

            itemView.item_title.text = model.title
            itemView.item_description.text = model.desc
            itemView.item_amount.text = model.price
            itemView.item_image.setImageResource(model.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binditems(arrayList[position])
        holder.itemView.setOnClickListener{

            // get position of selected item
            val model = arrayList.get(position)
            // get title desc and price of selcted item
            var gTitle : String = model.title
            var gDescription : String = model.desc
            var gAmount : String = model.price

            // get image of selected item
            var gImageView : Int = model.image

            // create intent in kotlin
            val intent = Intent(context,AnotherActivity::class.java)

            intent.putExtra("iTitle",gTitle)
            intent.putExtra("iDescription",gDescription)
            intent.putExtra("iAmount",gAmount)
            intent.putExtra("iImage",gImageView)

            context.startActivity(intent)

        }
    }
}