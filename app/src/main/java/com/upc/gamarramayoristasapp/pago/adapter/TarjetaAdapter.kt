package com.upc.gamarramayoristasapp.pago.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.pago.Tarjeta


class TarjetaAdapter(private val items:List<Tarjeta>) :RecyclerView.Adapter<TarjetaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TarjetaViewHolder(layoutInflater.inflate(R.layout.item_tarjeta,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TarjetaViewHolder, position: Int) {
        val item = items[position]
        holder.render(item)
    }


}