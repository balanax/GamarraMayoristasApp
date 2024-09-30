package com.upc.gamarramayoristasapp.perfil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.R

class OrdenesAdapter(
    private val ordenList: ArrayList<OrdenesModel>,
    private val onItemClick: (OrdenesModel) -> Unit
): RecyclerView.Adapter<OrdenesAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val nroorden =itemView.findViewById<TextView>(R.id.tvNroOrden)
        val fecha =itemView.findViewById<TextView>(R.id.tvFecha)
        val nrotraking =itemView.findViewById<TextView>(R.id.tvTraking)
        val cantidad =itemView.findViewById<TextView>(R.id.tvCantidad)
        val monto =itemView.findViewById<TextView>(R.id.tvMonto)
        val estado =itemView.findViewById<TextView>(R.id.tvEstado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdenesAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ordenes_item, parent,false))
    }

    override fun onBindViewHolder(holder: OrdenesAdapter.ViewHolder, position: Int) {
        val orden = ordenList[position]

        holder.nroorden.text = orden.nrorden
        holder.fecha.text = orden.fecha
        holder.nrotraking.text = orden.nrotraking
        holder.cantidad.text = orden.cantidad
        holder.monto.text = orden.monto
        holder.estado.text = orden.estado

        holder.itemView.setOnClickListener {
            onItemClick(orden)
        }
    }

    override fun getItemCount(): Int {
        return ordenList.size
    }
}