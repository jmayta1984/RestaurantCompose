package pe.edu.upc.restaurantsapp.data.models

class Restaurant(
    val id: Int,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val poster: String,
    val rating: Double
)