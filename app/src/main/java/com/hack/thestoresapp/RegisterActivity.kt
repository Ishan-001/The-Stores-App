package com.hack.thestoresapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl("http://storehopper.herokuapp.com/auth/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiHolder=retrofit.create(ApiHolder::class.java)

        register_btn.setOnClickListener{
            val role:String = if(seller_radio.isChecked) "StoreOwner" else "Customer"
            val user=User(
                name.text.toString(),
                phone.text.toString(),
                email_input.text.toString(),
                pass_input.text.toString(),
                role
            )
            val call=apiHolder.register(user)

            call?.enqueue(object: Callback<Token> {
                override fun onFailure(call: Call<Token>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    Toast.makeText(applicationContext, response.message(), Toast.LENGTH_SHORT).show()
                    if(response.message()=="Created") {
                        val intent=Intent(baseContext, SellerActivity::class.java)
                        intent.putExtra("Name",user.name)
                        intent.putExtra("Email",user.email)
                        intent.putExtra("Password",user.password)
                        startActivity(intent)
                        finish()
                    }
                }
            })
        }
    }
}