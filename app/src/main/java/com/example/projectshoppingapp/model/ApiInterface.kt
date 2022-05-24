package com.example.projectshoppingapp.model

import retrofit2.Call
import retrofit2.http.POST

interface ApiInterface {
    @POST("getorders")
    fun getProducts(): Call<OrdersData>



//    @POST("getorders")
//    fun getOrders(): Call<OrdersData>
}