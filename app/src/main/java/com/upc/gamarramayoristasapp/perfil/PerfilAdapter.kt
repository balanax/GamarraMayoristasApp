package com.example.appgamarra

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.perfil.OptionPerfil
import com.upc.gamarramayoristasapp.perfil.PerfilOptionType

class PerfilAdapter(var context: Context,
                     var ListProfile: MutableList<OptionPerfil>,
                    private val onItemClick: (PerfilOptionType) -> Unit
) :
    RecyclerView.Adapter<PerfilAdapter.ViewHolder>()
{
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val txttitulo: TextView = itemView.findViewById(R.id.tvTitle)
        val txtsubtitulo: TextView = itemView.findViewById(R.id.tvSubtitle)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val option = ListProfile[position]
                    onItemClick(option.tipo)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerfilAdapter.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(
            R.layout.perfil_option,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ListProfile.size
    }

    override fun onBindViewHolder(holder: PerfilAdapter.ViewHolder, position: Int) {
        val lista = ListProfile[position]
        holder.txttitulo.text = lista.titulo
        holder.txtsubtitulo.text = lista.subtitulo
    }


}