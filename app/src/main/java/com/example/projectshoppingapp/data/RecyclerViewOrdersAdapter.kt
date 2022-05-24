package com.example.projectshoppingapp.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.projectshoppingapp.R
import com.example.projectshoppingapp.model.Products


class RecyclerViewOrdersAdapter(private val products: List<Products>) :
    RecyclerView.Adapter<RecyclerViewOrdersAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val orderDate: TextView = view.findViewById(R.id.titem_expiry_date_orders)
        val orderTitle: TextView = view.findViewById(R.id.item_title_orders)
        val orderDesc: TextView = view.findViewById(R.id.item_description_orders)
        val orderPrice: TextView = view.findViewById(R.id.item_amount_orders)
        val image: ImageView = view.findViewById(R.id.item_image_orders)

        val sliderImageId = intArrayOf(
            R.drawable.bread_01,
            R.drawable.salt_04,
            R.drawable.sugar_05,
            R.drawable.oil_06,
            R.drawable.rice_03,
            R.drawable.milk_02,
            R.drawable.bread_01,
            R.drawable.salt_04
        )
    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout_orders, viewGroup, false)
        return ViewHolder(view)
    }
    // Replace the contents of a view (invoked by the layout manager)

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val product: Products = products[position]

        viewHolder.orderDate.text = product.expiryDate
        viewHolder.orderDesc.text = product.desc
        viewHolder.orderTitle.text = product.itemName
        viewHolder.orderPrice.text = "$" + product.price.toString()
        viewHolder.image.scaleType = ImageView.ScaleType.CENTER_CROP
        viewHolder.image.setImageResource(viewHolder.sliderImageId[position])
    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = products.size
}

