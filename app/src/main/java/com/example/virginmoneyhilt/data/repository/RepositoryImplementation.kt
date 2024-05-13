package com.example.virginmoneyhilt.data.repository

import com.example.virginmoneyhilt.data.api.ApiDetail
import com.example.virginmoneyhilt.data.api.ApiEndpoints
import com.example.virginmoneyhilt.data.model.people.PeopleItemModel
import com.example.virginmoneyhilt.data.model.rooms.RoomsItemModel
import javax.inject.Inject

class RepositoryImplementation @Inject constructor( private val apiDetails:ApiEndpoints):Repository {

    override suspend fun getPeople(): ArrayList<PeopleItemModel> = apiDetails.getPeople()

    override suspend fun getRooms(): ArrayList<RoomsItemModel> =  apiDetails.getRooms()

}