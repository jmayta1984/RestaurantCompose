package pe.edu.upc.restaurantsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pe.edu.upc.restaurantsapp.screens.Restaurants
import pe.edu.upc.restaurantsapp.screens.RestaurantsViewModel
import pe.edu.upc.restaurantsapp.ui.theme.RestaurantsAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: RestaurantsViewModel by viewModels()

        setContent {
            RestaurantsAppTheme {
                Restaurants(viewModel)
            }
        }
    }


}
