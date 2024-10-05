package com.upc.gamarramayoristasapp.producto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.ListCarrito
import com.upc.gamarramayoristasapp.carrito.adapter.CarritoViewHolder
import com.upc.gamarramayoristasapp.producto.ListCategoria

class CategoriaAdapter (private val categoriaList:List<ListCategoria>) : RecyclerView.Adapter<CategoriaViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoriaViewHolder(layoutInflater.inflate(R.layout.item_listcategoria, parent, false))
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        val item = categoriaList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int =  categoriaList.size


}