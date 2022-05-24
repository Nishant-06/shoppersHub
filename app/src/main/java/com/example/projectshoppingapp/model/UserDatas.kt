package com.example.projectshoppingapp.model

data class UserDatas(
    val id:String,
    val cart_name:String,
    val cart_image:String,
    val cart_des:String,
    val cart_amt:String
){
    internal constructor(
        cart_name: String,
        cart_image: String,
        cart_des: String,
        cart_amt: String

    ):this(
        id="",
        cart_name = cart_name,
        cart_image=cart_image,
        cart_des = cart_des,
        cart_amt = cart_amt

    ){}
}