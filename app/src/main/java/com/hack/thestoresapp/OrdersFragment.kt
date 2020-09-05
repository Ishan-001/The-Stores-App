package com.hack.thestoresapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_orders.view.*

class OrdersFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.activity_orders, container, false)
        val ordersList= arrayListOf<Order>()
        ordersList.add(Order("Ishan", "Maggi x2\nBournvita x1\nParle-G x20"))
        ordersList.add(Order("Hari", "Chicken 1Kg\nOnions 500g"))

        val adapter:OrderAdapter=OrderAdapter(context!!, ordersList)
        root.orders.adapter=adapter
        root.orders.layoutManager=LinearLayoutManager(context)

        return root
    }
}