package com.hack.thestoresapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_seller.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SellerActivity : AppCompatActivity() {

    var token:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller)
        bottom_nav.setOnNavigationItemSelectedListener(navListener)

        if(intent!=null) {

            val loginDetails = loginDetails(
                intent.extras!!.getString("Name"),
                intent.extras!!.getString("Email"),
                intent.extras!!.getString("Password")
            )

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://storehopper.herokuapp.com/auth/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiHolder = retrofit.create(ApiHolder::class.java)

            val call = apiHolder.login(loginDetails)
            call?.enqueue(object : Callback<Token> {
                override fun onFailure(call: Call<Token>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    token= response.body()!!.auth_token
                    val preferences=baseContext.getSharedPreferences("MY_PREFERENCES", Context.MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = preferences.edit()
                    editor.putString("Token",token)
                    editor.apply()
                }
            })
        }
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