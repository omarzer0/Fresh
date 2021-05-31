package omar.az.fresh.ui.details

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import omar.az.fresh.db.ProductDatabase
import omar.az.fresh.pojo.Product
import omar.az.fresh.repository.ProductRepository

class ProductDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val productRepository = ProductRepository(ProductDatabase(application))
    val choiceSize: MutableLiveData<Int> = MutableLiveData(1)
    val tempInputNumber: MutableLiveData<Int> = MutableLiveData(0)

    fun insertProduct(product: Product) = viewModelScope.launch {
        productRepository.insertProduct(product)
    }

    fun updateProduct(id: Long, numberOfItems: Int, cupSize: Int, sugarLevel: Int, finalPrice:Double)
    = viewModelScope.launch {
        productRepository.updateProduct(id,numberOfItems,cupSize,sugarLevel,finalPrice)
    }
}