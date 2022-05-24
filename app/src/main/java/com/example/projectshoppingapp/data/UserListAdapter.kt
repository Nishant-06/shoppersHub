package com.example.projectshoppingapp.data

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectshoppingapp.MyDBHelper
import com.example.projectshoppingapp.R
import com.example.projectshoppingapp.data.viewholder.UserViewHolder
import com.example.projectshoppingapp.model.UserDatas

class UserListAdapter(
    private val c:Context,listUser:ArrayList<UserDatas>
) :RecyclerView.Adapter<UserViewHolder>()
{

    private val listUs:ArrayList<UserDatas>
    private val mDataBase:MyDBHelper
    init {
        this.listUs=listUser
        mDataBase= MyDBHelper(c)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val v=inflater.inflate(R.layout.cart_layout,parent,false)
        return UserViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       val newList= listUs[position]
        holder.itemName.text=newList.cart_name
        holder.itemImage.setImageResource(newList.cart_image.toInt())
        holder.itemDes.text=newList.cart_des
        holder.itemAmt.text=newList.cart_amt

        holder.deleteBtn.setOnClickListener {
            mDataBase.deleteInfo(newList.id.toInt())
            listUs.removeAt(position)
            notifyDataSetChanged()
        }




    }

    override fun getItemCount(): Int {
        return  listUs.size
    }


}