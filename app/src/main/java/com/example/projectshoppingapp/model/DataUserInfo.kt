package com.example.projectshoppingapp.model

interface DataUserInfo {

    fun listUser():ArrayList<UserDatas>
    fun addUserInfo(us:UserDatas)
    fun updateInfo(us:UserDatas)
    fun deleteInfo(id:Int)



    companion object{
        const val DATABASE_NAME="USERDB"
        const val DATABASE_VERSION=1
        const val TABLE_USER="CART"
        const val COLUMN_ID="USERID"
        const val COLUMN_NAME="ITEM_NAME"
        const val COLUMN_IMAGE="ITEM_IMAGE"
        const val COLUMN_DES="ITEM_DES"
        const val COLUMN_AMT="AMOUNT"


        //select data
        const val USER_SELECT="SELECT * FROM CART"

        //create table
        const val TABLE_GET="DROP TABLE EXISTS CART"

        //set table
        const val TABLE_SET="CREATE TABLE CART(USERID INTEGER PRIMARY KEY AUTOINCREMENT, ITEM_NAME TEXT,ITEM_DES TEXT,AMOUNT TEXT)"

    }
}