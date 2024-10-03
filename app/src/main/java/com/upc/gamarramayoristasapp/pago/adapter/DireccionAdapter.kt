package com.upc.gamarramayoristasapp.pago.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.pago.Direccion


class DireccionAdapter(private val items:List<Direccion>) :RecyclerView.Adapter<DireccionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DireccionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DireccionViewHolder(layoutInflater.inflate(R.layout.item_direccion,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DireccionViewHolder, position: Int) {
        val item = items[position]
        holder.render(item)
    }

}



