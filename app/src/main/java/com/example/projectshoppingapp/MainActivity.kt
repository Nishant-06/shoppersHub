package com.example.projectshoppingapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showHome()

        registeration.setOnClickListener {
            showRegistration()
        }
        login.setOnClickListener {
            showLogin()
        }

        var helper=MyDBHelper(applicationContext)
        var db=helper.readableDatabase
        var rs=db.rawQuery("SELECT * FROM USERS",null)

        if(rs.moveToNext())
            Toast.makeText(applicationContext,rs.getString(1), Toast.LENGTH_LONG).show()

        save.setOnClickListener {
            var cv= ContentValues()
            cv.put("FNAME",name.text.toString())
            cv.put("LNAME",lastnameid.text.toString())
            cv.put("UNAME",email.text.toString())
            cv.put("PWD",ppassword_reg.text.toString())
            cv.put("MOB",mobileregid.text.toString())
            db.insert("USERS",null,cv)

            name.setText("")
            lastnameid.setText("")
            email.setText("")
            ppassword_reg.setText("")
            mobileregid.setText("")

            showHome()
        }
        signupid.setOnClickListener{
            showRegistration()
        }
        login_button.setOnClickListener {
            var args= listOf<String>(login_email.text.toString(),login_password.text.toString()).toTypedArray()
            var rs=db.rawQuery("SELECT * FROM USERS WHERE UNAME=? AND PWD=?",args)
            if(rs.moveToNext()) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
//            val intent=Intent(this,HomeActivity::class.java)
//            startActivity(intent)
            else
                Toast.makeText(applicationContext,"invalid", Toast.LENGTH_LONG).show()

        }

    }
    private fun showRegistration(){
        registration_layout.visibility= View.VISIBLE
        login_layout.visibility= View.GONE
        home_11.visibility= View.GONE
    }
    private fun showLogin(){
        registration_layout.visibility= View.GONE
        login_layout.visibility= View.VISIBLE
        home_11.visibility= View.GONE
    }
    private fun showHome(){
        registration_layout.visibility= View.GONE
        login_layout.visibility= View.GONE
        home_11.visibility= View.VISIBLE
    }
}
