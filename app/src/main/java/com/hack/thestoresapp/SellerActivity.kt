package com.hack.thestoresapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_seller.*

class SellerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller)
        bottom_nav.setOnNavigationItemSelectedListener(navListener)
    }
    private val navListener= BottomNavigationView.OnNavigationItemSelectedListener {
        var selectedFragment: Fragment? =null

        when(it.itemId){
            R.id.orders->selectedFragment=OrdersFragment()
            R.id.stores->selectedFragment=StoresFragment()
        }

        supportFragmentManager.beginTransaction().replace(R.id.container, selectedFragment!!).commit()
        return@OnNavigationItemSelectedListener true
    }
}