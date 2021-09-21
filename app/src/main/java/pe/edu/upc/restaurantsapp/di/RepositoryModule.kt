package pe.edu.upc.restaurantsapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import pe.edu.upc.restaurantsapp.data.remote.RestaurantService
import pe.edu.upc.restaurantsapp.data.repository.RestaurantRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRestaurantRepository(
        restaurantService: RestaurantService
    ): RestaurantRepository {
        return RestaurantRepository(restaurantService)
    }
}