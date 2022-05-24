package com.example.projectshoppingapp.model
import com.google.gson.annotations.SerializedName

data class Orders(
    @SerializedName("order id")
    var orderId: Int,
    @SerializedName("userr id")
    var userId: Int,
    @SerializedName("order date")
    var orderDate: String,
    @SerializedName("order total")
    var orderTotal: Int,
    val data: List<Products>
)