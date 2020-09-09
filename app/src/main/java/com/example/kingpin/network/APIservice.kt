package com.example.kingpin.network

import com.example.kingpin.models.hours
import com.example.kingpin.models.skillIQ
import retrofit2.http.GET

interface APIservice {
    @GET("/api/hours")
    suspend fun getHoursData(): List<hours>

    @GET("/api/skilliq")
    suspend fun getSkilliqData(): List<skillIQ>
}