package com.example.projectshoppingapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import com.example.projectshoppingapp.model.UserDatas
import kotlinx.android.synthetic.main.activity_another.*
import kotlinx.android.synthetic.main.user_registration.*

class AnotherActivity : AppCompatActivity() {
    private lateinit var dataHelper:MyDBHelper
    var db:SQLiteDatabase?=null
    var imageUri:Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        val actionBar : ActionBar?=supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        var itent = intent
        val aTitle = intent.getStringExtra("iTitle")
        val aDescription = intent.getStringExtra("iDescription")
        val aAmount = intent.getStringExtra("iAmount")
        val aImage = intent.getIntExtra("iImage",0)


        actionBar.setTitle(aTitle.toString())
        amount_item_description.text=aTitle.toString()
        free_delivery_item_description.text=aDescription.toString()
        sold_by_item_description.text=aAmount.toString()
        image_item_description.setImageResource(aImage)



        dataHelper= MyDBHelper(applicationContext)
        imageUri= Uri.parse(aImage.toString())
//        imageUri=contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,ContentValues())

//        add_to_cart.setOnClickListener {
//            sendData()
//
//        }

//        var helper=MyDBHelper(applicationContext)
//        var db=helper.readableDatabase
        var helper=MyDBHelper(applicationContext)
        var db=helper.readableDatabase
//
        add_to_cart.setOnClickListener {

            sendData(it)


//            var cv= ContentValues()
//            cv.put("ITEM_NAME",amount_item_description.text.toString())
//            cv.put("ITEM_IMAGE",image_item_description.toString())
//            cv.put("ITEM_DES",free_delivery_item_description.text.toString())
//            cv.put("AMOUNT",sold_by_item_description.text.toString())
//            db.insert("CART",null,cv)

            Toast.makeText(applicationContext,"item added",Toast.LENGTH_SHORT).show()






        }

   }

    private fun sendData(v: View?) {
        val newUser=UserDatas(
            amount_item_description.text.toString(),
            ""+imageUri,
            free_delivery_item_description.text.toString(),
            sold_by_item_description.text.toString()

        )
        dataHelper.addUserInfo(newUser)

    }


}