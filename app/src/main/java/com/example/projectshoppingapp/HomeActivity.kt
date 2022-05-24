package com.example.projectshoppingapp

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    lateinit var feedback: Feedback
    lateinit var cart: Cart
    lateinit var home: Home
    lateinit var ordersFragment: OrdersFragment
    lateinit var help: Help
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val drawerLayout: DrawerLayout = drawer_Layout_id
        val navView: NavigationView = nav_view

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener(this)

        home = Home()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_nav_cont_id, home)
            .commit()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {

            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_home-> {
                home = Home()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_nav_cont_id, home)
                    .commit()
            }
            R.id.nav_cart-> {
                cart=Cart()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_nav_cont_id, cart)
                    .commit()
            }
            R.id.nav_logout-> {
                val builder=AlertDialog.Builder(this)
                builder.setTitle("Are you sure!")
                builder.setMessage("Do you really want to Logout?")
                builder.setPositiveButton("Yes",{dialogInterface:DialogInterface,i:Int->
                    val intent=Intent(this,MainActivity::class.java)
                    startActivity(intent)
                })
                builder.setNegativeButton("No",{dialogInterface:DialogInterface,i:Int->})
                builder.show()
            }
            R.id.nav_order -> {
                ordersFragment=OrdersFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_nav_cont_id, ordersFragment)
                    .commit()
            }
            R.id.nav_help -> {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
                startActivity(i)
//                help = Help()
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.frame_nav_cont_id,help)
//                    .commit()
            }

            R.id.nav_feedback -> {
                feedback = Feedback()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_nav_cont_id, feedback)
                    .commit()
            }

        }
        drawer_Layout_id.closeDrawer((GravityCompat.START))
        return true
    }

    override fun onBackPressed() {
        if(drawer_Layout_id.isDrawerOpen(GravityCompat.START)){
            drawer_Layout_id.closeDrawer(GravityCompat.START)
        }
        else {
            super.onBackPressed()
        }
    }
}
