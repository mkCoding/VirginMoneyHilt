package com.example.virginmoneyhilt.data.repository

import com.example.virginmoneyhilt.data.api.ApiDetail
import com.example.virginmoneyhilt.data.model.people.PeopleItemModel
import com.example.virginmoneyhilt.data.model.rooms.RoomsItemModel
import retrofit2.http.GET

//Benefits of Repository
//   - Centralized Endpoints
//   - Different implementations based on our need -> Application Code, Testing, Use Case
interface Repository{

    @GET(ApiDetail.PEOPLE_ENDPOINT)
    suspend fun getPeople(): ArrayList<PeopleItemModel>


    @GET(ApiDetail.ROOMS_ENDPOINT)
    suspend fun getRooms(): ArrayList<RoomsItemModel>
}
