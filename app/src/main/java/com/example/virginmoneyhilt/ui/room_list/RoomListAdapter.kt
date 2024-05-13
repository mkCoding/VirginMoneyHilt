package com.example.virginmoneyhilt.ui.room_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.virginmoneyhilt.data.model.rooms.RoomsItemModel
import com.example.virginmoneyhilt.R
import com.example.virginmoneyhilt.databinding.ElementRoomBinding

class RoomListAdapter(
    val roomList: ArrayList<RoomsItemModel>):
    RecyclerView.Adapter<RoomListAdapter.MyViewHolder>(){

        inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

            val binding = ElementRoomBinding.bind(itemView)

            fun updateUI(roomsItemModel: RoomsItemModel) {
                //Handle the UI changes based on current state

                binding.apply {
                    tvRoomId.text = roomsItemModel.id
                    when(roomsItemModel.isOccupied){
                        true -> tvRoomOccupiedStatus.text = "Occupied"
                        false-> tvRoomOccupiedStatus.text = "Vacant"
                        else->{}
                    }

                }
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.element_room, parent, false))

    }

    override fun getItemCount(): Int = roomList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.updateUI(roomList[position])
//        holder.binding.root.setOnClickListener {
////            function.invoke(roomList.get(position))
//        }
    }


}