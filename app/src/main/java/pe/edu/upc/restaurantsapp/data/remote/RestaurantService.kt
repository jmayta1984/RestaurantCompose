package pe.edu.upc.restaurantsapp.data.remote

import pe.edu.upc.restaurantsapp.data.models.Restaurant
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantService {

    @GET("restaurants")
    suspend fun fetchRestaurants(): Response<List<Restaurant>>
}