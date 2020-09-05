package com.hack.thestoresapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoreAdapter internal constructor(
    private val context: Context,
    private val storeList: ArrayList<Store>
) :
    RecyclerView.Adapter<StoreAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.stores_entry, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.storeName.text= storeList[position].store_name
        holder.storeAddress.text=storeList[position].address
        holder.peakTime.text=storeList[position].peak_time
        holder.storeType.text=storeList[position].type
    }

    override fun getItemCount(): Int {
        return storeList.size
    }

    class ViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var storeName: TextView = itemView.findViewById(R.id.store_name)
        var storeAddress: TextView = itemView.findViewById(R.id.store_address)
        var storeType: TextView = itemView.findViewById(R.id.store_type)
        var peakTime: TextView = itemView.findViewById(R.id.store_peak)
    }
}