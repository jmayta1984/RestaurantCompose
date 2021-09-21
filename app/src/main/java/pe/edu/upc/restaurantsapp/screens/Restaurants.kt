package pe.edu.upc.restaurantsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import coil.compose.rememberImagePainter
import pe.edu.upc.restaurantsapp.data.models.Restaurant

@Composable
fun Restaurants(
    viewModel: RestaurantsViewModel,
) {
    val restaurants: List<Restaurant> by viewModel.restaurants.observeAsState(listOf())
    viewModel.fetchRestaurants()
    Scaffold {
        RestaurantList(restaurants)
    }
}

@Composable
fun RestaurantList(restaurants: List<Restaurant>) {
    LazyColumn {
        items(restaurants) { restaurant ->
            RestaurantRow(restaurant)
        }
    }
}

@Composable
fun RestaurantRow(restaurant: Restaurant) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        elevation = 2.dp
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            RestaurantImage(restaurant)
            Spacer(Modifier.width(8.dp))
            Column(modifier = Modifier.align(alignment = Alignment.CenterVertically)) {
                Text(text = restaurant.name, fontWeight = FontWeight.Bold)
                Text(text = restaurant.address, style = MaterialTheme.typography.caption)
            }
        }
    }

}

@Composable
fun RestaurantImage(restaurant: Restaurant) {
    Image(
        painter = rememberImagePainter(restaurant.poster),
        contentDescription = null,
        modifier = Modifier
            .size(64.dp)
            .clip(shape = RoundedCornerShape(4.dp)),
        contentScale = ContentScale.Crop
    )
}
