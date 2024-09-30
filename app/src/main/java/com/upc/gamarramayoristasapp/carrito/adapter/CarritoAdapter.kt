package com.upc.gamarramayoristasapp.carrito.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.ListCarrito

class CarritoAdapter (private val carritoList:List<ListCarrito>) : RecyclerView.Adapter<CarritoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CarritoViewHolder(layoutInflater.inflate(R.layout.item_listcarrito, parent, false))
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        val item = carritoList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int =  carritoList.size


}