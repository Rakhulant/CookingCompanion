package com.rakhulant.cookingcompanion2.data


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rakhulant.cookingcompanion2.R
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var itemList = emptyList<Item>()
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.itemView.itemName.text = currentItem.itemName
        holder.itemView.itemQty.text = currentItem.qty
        holder.itemView.chekerBox.isChecked = false
    }
    fun setData(item: List<Item>){
        this.itemList = item
        notifyDataSetChanged()
    }
}