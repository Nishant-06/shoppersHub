package com.example.projectshoppingapp.data.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cart_layout.view.*

class UserViewHolder(v:View):RecyclerView.ViewHolder(v) {

    val itemName=v.reTitle
    val itemImage=v.reImage
    val itemDes=v.reDescription
    val itemAmt=v.reAmount
    val deleteBtn=v.deletecartitem_id
}