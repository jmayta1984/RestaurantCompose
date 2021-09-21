package pe.edu.upc.restaurantsapp.data.repository

import pe.edu.upc.restaurantsapp.data.remote.RestaurantService
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val restaurantService: RestaurantService
) {
    suspend fun fetchRestaurants() = restaurantService.fetchRestaurants()
}