package com.example.virginmoneyhilt.ui.room_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoneyhilt.data.api.RetrofitInstance
import com.example.virginmoneyhilt.data.model.people.PeopleItemModel
import com.example.virginmoneyhilt.data.model.rooms.RoomsItemModel
import kotlinx.coroutines.launch

class RoomListViewModel: ViewModel(){


    private val _roomList = MutableLiveData<ArrayList<RoomsItemModel>>()
    val roomList: LiveData<ArrayList<RoomsItemModel>> = _roomList


    init{
        getAllRooms()
    }

    private fun getAllRooms() {

        //Rooms contains 1 array list. The Array list contains RoomItemModel objects
        //RoomItemModel contains attribute variables for each room

        //the people list holds RoomItemModel objects
        viewModelScope.launch {

            val result = RetrofitInstance.apiClient.getRooms() //this actually makes the api call to the endpoint

            if(result!=null){
                _roomList.postValue(result)

            }

            Log.d("Returned from API",result.toString())

        }

    }

}