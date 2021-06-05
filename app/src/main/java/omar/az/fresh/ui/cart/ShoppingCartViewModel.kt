package omar.az.fresh.ui.cart

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import omar.az.fresh.db.ProductDatabase
import omar.az.fresh.pojo.Product
import omar.az.fresh.repository.ProductRepository
import javax.inject.Inject

@HiltViewModel
class ShoppingCartViewModel @Inject constructor(
    private val productRepository:ProductRepository
) : ViewModel() {

//    private val productRepository = ProductRepository(ProductDatabase(application))


    fun getAllProducts() = productRepository.getAllProducts()

    fun deleteProduct(id: Long) = viewModelScope.launch {
        productRepository.deleteProduct(id)
    }
}