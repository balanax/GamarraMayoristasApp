package com.example.appgamarra

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.perfil.OptionPerfil

class PerfilAdapter(var context: Context,
                     var ListProfile: MutableList<OptionPerfil>) :
    RecyclerView.Adapter<PerfilAdapter.ViewHolder>()
{
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        lateinit var txttitulo: TextView
        init{
            txttitulo = itemView.findViewById(R.id.tvTitle)
        }
        lateinit var txtsubtitulo: TextView
        init{
            txtsubtitulo = itemView.findViewById(R.id.tvSubtitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerfilAdapter.ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(
            R.layout.perfil_option,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ListProfile.size
    }

    override fun onBindViewHolder(holder: PerfilAdapter.ViewHolder, position: Int) {
        var lista = ListProfile[position]
        holder.txttitulo.text = lista.Titulo
        holder.txtsubtitulo.text = lista.Subtitulo
    }


}