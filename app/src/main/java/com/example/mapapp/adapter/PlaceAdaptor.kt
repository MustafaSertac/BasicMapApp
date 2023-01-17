package com.example.mapapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mapapp.MapsActivity
import com.example.mapapp.databinding.RecyclerowBinding
import com.example.mapapp.model.Place

class PlaceAdaptor(var placeList: List<Place>) : RecyclerView.Adapter<PlaceAdaptor.PlaceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val recyclerRowBinding: RecyclerowBinding = RecyclerowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceHolder(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.recyclerRowBinding.recyclerowtextview.setText(placeList[position].name)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MapsActivity::class.java)
            intent.putExtra("place", placeList[position])
            intent.putExtra("info", "old")
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    class PlaceHolder(val recyclerRowBinding: RecyclerowBinding) : RecyclerView.ViewHolder(recyclerRowBinding.root) {

    }
}