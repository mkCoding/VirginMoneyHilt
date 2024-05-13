package com.example.virginmoneyhilt.ui.room_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneyhilt.databinding.FragmentRoomListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [RoomListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RoomListFragment : Fragment() {

    private lateinit var binding: FragmentRoomListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i("TAG: RoomListFragment","onCreateView")
        //1st initialize the binding
        binding = FragmentRoomListBinding.inflate(inflater,container,false)

        //2nd create reference for view model
        val roomListViewModel = ViewModelProvider(this)[RoomListViewModel::class.java]

        //3rd binding root
        val root = binding.root


        //4th get info from live data
        binding.apply {
            roomListViewModel.roomList.observe(viewLifecycleOwner){
                binding.rvRooms.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = RoomListAdapter(it)
                }

            }
        }




        // Inflate the layout for this fragment
        return root
    }

}