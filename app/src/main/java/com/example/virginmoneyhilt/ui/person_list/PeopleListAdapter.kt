package com.example.virginmoneyhilt.ui.person_list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.virginmoneyhilt.data.model.people.PeopleItemModel
import com.example.virginmoneyhilt.R
import com.example.virginmoneyhilt.databinding.ElementPersonBinding


class PeopleListAdapter(
    val peopleList: ArrayList<PeopleItemModel>,
    val function: (PeopleItemModel) -> Unit
):Adapter<PeopleListAdapter.MyViewHolder>(){

    //1 Create view holder class
    inner class MyViewHolder(itemView: View):ViewHolder(itemView){
        val binding = ElementPersonBinding.bind(itemView)

        fun updateUI(peopleItemModel: PeopleItemModel) {
            //Handle the UI changes based on current state

            binding.apply {
                Glide.with(itemView.context).load(peopleItemModel.avatar).placeholder(R.drawable.person_icon).into(ivPersonPic)
                tvPersonName.text = peopleItemModel.firstName
            }
        }


    }

    //retains reference of XML in UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.element_person, parent, false))
    }


    //holds the total count of the list
    override fun getItemCount(): Int = peopleList.size


    //Binds the position with the current item UI
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.updateUI(peopleList[position])

        holder.binding.root.setOnClickListener {
            function.invoke(peopleList.get(position))

        }
    }
}