package com.example.projectshoppingapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.projectshoppingapp.model.DataUserInfo
import com.example.projectshoppingapp.model.UserDatas

class MyDBHelper(context: Context): SQLiteOpenHelper(context,DataUserInfo.DATABASE_NAME,null,1),DataUserInfo {

    lateinit var values:ContentValues
    lateinit var db:SQLiteDatabase
    var curs : Cursor?=null


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT,LNAME TEXT,UNAME TEXT, PWD TEXT,MOB TEXT)")
        db?.execSQL("INSERT INTO USERS(FNAME,LNAME,UNAME,PWD,MOB) VALUES('jon','don','abc@abc.com','abc','qwe')")
        db?.execSQL("INSERT INTO USERS(FNAME,LNAME,UNAME,PWD,MOB) VALUES('jonere','donere','abrc@abc.com','aberc','qweer')")
        db?.execSQL("CREATE TABLE FEEDBACK(USERID INTEGER PRIMARY KEY AUTOINCREMENT, RATING TEXT,MESSAGE TEXT)")
        db?.execSQL("INSERT INTO FEEDBACK(RATING,MESSAGE) VALUES('4','good')")
        db?.execSQL("CREATE TABLE CART(USERID INTEGER PRIMARY KEY AUTOINCREMENT, ITEM_NAME TEXT,ITEM_IMAGE TEXT,ITEM_DES TEXT,AMOUNT TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DataUserInfo.TABLE_GET)
        onCreate(db)
    }

    //set userinfo
    override fun listUser(): ArrayList<UserDatas> {
        db=this.readableDatabase
        val storeUserInfo=ArrayList<UserDatas>()
        curs=db.rawQuery(DataUserInfo.USER_SELECT,null)
        if (curs!!.moveToNext()){
            do{
                val id =curs!!.getString(0)
                val cart_name =curs!!.getString(1)
                val cart_image =curs!!.getString(2)
                val cart_des=curs!!.getString(3)
                val cart_amt =curs!!.getString(4)
                storeUserInfo.add(UserDatas(id,cart_name,cart_image,cart_des,cart_amt))
            }while (curs!!.moveToNext())
        }
        curs!!.requery()
        curs!!.close()
        return storeUserInfo
    }

    override fun addUserInfo(us: UserDatas) {
        values= ContentValues()
        db=this.readableDatabase
        curs=db.rawQuery(DataUserInfo.USER_SELECT,null)
        values.put(DataUserInfo.COLUMN_NAME,us.cart_name)
        values.put(DataUserInfo.COLUMN_IMAGE,us.cart_image)
        values.put(DataUserInfo.COLUMN_DES,us.cart_des)
        values.put(DataUserInfo.COLUMN_AMT,us.cart_amt)
        db.insert("CART",null,values)
        curs!!.requery()
    }

    override fun updateInfo(us: UserDatas) {
        values= ContentValues()
        db=this.readableDatabase
        curs=db.rawQuery(DataUserInfo.USER_SELECT,null)
        values.put(DataUserInfo.COLUMN_NAME,us.cart_name)
        values.put(DataUserInfo.COLUMN_IMAGE,us.cart_image)
        values.put(DataUserInfo.COLUMN_DES,us.cart_des)
        values.put(DataUserInfo.COLUMN_AMT,us.cart_amt)
        db.update("CART",values,"${DataUserInfo.COLUMN_ID}=?", arrayOf(us.id))
        curs!!.requery()
    }

    override fun deleteInfo(id: Int) {
        db=this.writableDatabase
        db.delete("CART","${DataUserInfo.COLUMN_ID}=?", arrayOf(id.toString()))
    }


}