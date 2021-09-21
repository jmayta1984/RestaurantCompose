package pe.edu.upc.restaurantsapp.screens

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.restaurantsapp.data.models.Restaurant
import pe.edu.upc.restaurantsapp.data.repository.RestaurantRepository
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) : ViewModel() {

    private var _restaurants = MutableLiveData<List<Restaurant>>()
    val restaurants get() = _restaurants

    fun fetchRestaurants() {
        viewModelScope.launch {
            val response = restaurantRepository.fetchRestaurants()
            if (response.isSuccessful && response.body() != null) {
                _restaurants.postValue(response.body())
            }
        }
    }
}