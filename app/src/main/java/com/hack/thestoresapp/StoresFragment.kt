package com.hack.thestoresapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_stores.view.*

class StoresFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.activity_stores, container, false)
        val storesList= arrayListOf<Store>()
        storesList.add(Store("SKS Enterprises","64, Averton Street, Washington DC"," 6:00 to 8:00", null, "Grocery"))
        storesList.add(Store("Biker's Hub","42, Hamilson Garden, Pennsylvania","12:00 to 14:00",null,"Rentals"))

        val adapter:StoreAdapter= StoreAdapter(context!!, storesList)
        root.stores.adapter=adapter
        root.stores.layoutManager=LinearLayoutManager(context)

        return root
    }
}