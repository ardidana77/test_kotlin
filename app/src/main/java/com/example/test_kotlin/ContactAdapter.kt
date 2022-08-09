package com.example.test_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class ContactAdapter(private var contactList: List<ContactModel>) :
RecyclerView.Adapter<ContactAdapter.MyViewHolder>(){
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var nama: TextView = view.findViewById(R.id.textVIewNamaAlat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_list_contact,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val datacontact = contactList[position]
        holder.nama.text = datacontact.getfirstname()
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

}