package com.example.kingpin.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kingpin.models.hours
import com.example.kingpin.models.skillIQ
import com.example.kingpin.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call


class SkillViewModel : ViewModel() {
    private val il = MutableLiveData<ArrayList<skillIQ>>()
    private val hl = MutableLiveData<ArrayList<hours>>()
    val iqList: LiveData<ArrayList<skillIQ>>
        get() = il
    val hourList: LiveData<ArrayList<hours>>
        get() = hl


    fun getSkilliqList() {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                val response = RetrofitBuilder.createApiService().getSkilliqData()
                il.postValue(response as ArrayList<skillIQ>)
            } catch (e: Exception) {
                Log.d("Exception: ", e.message.toString())
            }

        }

    }

    fun getHoursList() {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                val response = RetrofitBuilder.createApiService().getHoursData()
                hl.postValue(response as ArrayList<hours>?)
            } catch (e: Exception) {
                Log.d("Exception: ", e.message.toString())
            }

        }

    }

    fun sendForm(firstName: String, lastName: String, email: String, github: String): Call<Void> {

        return RetrofitBuilder.createSubmitService().sendForm(firstName, lastName, email, github)
    }


}