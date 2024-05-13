package com.example.virginmoneyhilt.data.api

import com.example.virginmoneyhilt.data.model.people.PeopleItemModel
import com.example.virginmoneyhilt.data.model.rooms.RoomsItemModel
import retrofit2.http.GET

interface ApiEndpoints{

    @GET(ApiDetail.PEOPLE_ENDPOINT)
    suspend fun getPeople(): ArrayList<PeopleItemModel>


    @GET(ApiDetail.ROOMS_ENDPOINT)
    suspend fun getRooms(): ArrayList<RoomsItemModel>
}