package com.example.virginmoneyhilt.ui.room_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoneyhilt.data.api.RetrofitInstance
import com.example.virginmoneyhilt.data.model.people.PeopleItemModel
import com.example.virginmoneyhilt.data.model.rooms.RoomsItemModel
import com.example.virginmoneyhilt.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomListViewModel @Inject constructor(val repository: Repository) : ViewModel(){


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

            val result = repository.getRooms() //this actually makes the api call to the endpoint

            if(result!=null){
                _roomList.postValue(result)

            }

            Log.d("Returned from API",result.toString())

        }

    }

}