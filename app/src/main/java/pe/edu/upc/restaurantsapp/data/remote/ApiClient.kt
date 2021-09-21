package pe.edu.upc.restaurantsapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val API_BASE_URL = "https://upc-pre-202101-si672-final.herokuapp.com/"
    private var restaurantService: RestaurantService? = null

    fun build(): RestaurantService {
        val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit = builder.build()
        restaurantService = retrofit.create(RestaurantService::class.java)
        return restaurantService as RestaurantService
    }
}