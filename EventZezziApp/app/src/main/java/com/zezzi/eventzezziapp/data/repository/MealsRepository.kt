package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): Flow<MealCategoriesResponse?> = flow) {
        return webService.getMeals().enqueue(object : Callback<MealsCategoriesResponse> {
            try {
                val response = webService.getMeals().execute()
                if (response.isSuccessful){
                    emit(response.body())
                }
            } catch (e: Exception){

            }
        }.flowOn(Dispatchers.IO)
    }
}