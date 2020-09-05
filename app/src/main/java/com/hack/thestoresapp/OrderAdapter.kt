package com.hack.thestoresapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter internal constructor(
    private val context: Context,
    private val orderList: ArrayList<Order>
) :
    RecyclerView.Adapter<OrderAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.orders_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.customerName.text= orderList[position].customer_name
        holder.items.text=orderList[position].items
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    class ViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var customerName: TextView = itemView.findViewById(R.id.customer_name)
        var items: TextView = itemView.findViewById(R.id.items)
    }
}