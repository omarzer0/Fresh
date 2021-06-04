package omar.az.fresh.ui.cart

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import omar.az.fresh.db.ProductDatabase
import omar.az.fresh.pojo.Product
import omar.az.fresh.repository.ProductRepository

class ShoppingCartViewModel(application: Application) : AndroidViewModel(application) {

    private val productRepository = ProductRepository(ProductDatabase(application))


    fun getAllProducts() = productRepository.getAllProducts()

    fun deleteProduct(id: Long) = viewModelScope.launch {
        productRepository.deleteProduct(id)
    }
}