package com.example.banderas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banderas.R
import com.example.banderas.databinding.ItemPaisBinding
import com.example.banderas.retrofit.PaisesResponseItem
import com.squareup.picasso.Picasso

class PaisesAdapter(var listaPaises: List<PaisesResponseItem>) :
    RecyclerView.Adapter<PaisesAdapter.PaisesViewHolder>() {

    var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PaisesViewHolder {

        context = parent.context

        val layoutInflater = LayoutInflater.from(context)
        return PaisesViewHolder(layoutInflater.inflate(R.layout.item_pais, parent, false))
    }

    override fun onBindViewHolder(
        holder: PaisesViewHolder,
        position: Int
    ) {

        val item = listaPaises[position]
        holder.binding.textPais.text = item.name.official

        //Llamamos a Picasso
        Picasso.get()
            //Cargamos el url
            .load(item.flags.png)
            //Insertamos la imagen en el xml
            .into(holder.binding.imgBandera)
    }

    override fun getItemCount(): Int = listaPaises.size


    inner class PaisesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var binding = ItemPaisBinding.bind(view)

    }


}