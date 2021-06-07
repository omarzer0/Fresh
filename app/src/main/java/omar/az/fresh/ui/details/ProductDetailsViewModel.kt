package omar.az.fresh.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import omar.az.fresh.pojo.Product
import omar.az.fresh.repository.ProductRepository
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    val choiceSize: MutableLiveData<Int> = MutableLiveData(1)
    val tempInputNumber: MutableLiveData<Int> = MutableLiveData(0)

    fun insertProduct(product: Product) = viewModelScope.launch {
        productRepository.insertProduct(product)
    }

    fun updateProduct(
        id: Long,
        numberOfItems: Int,
        cupSize: Int,
        sugarLevel: Int,
        finalPrice: Double
    ) = viewModelScope.launch {
        productRepository.updateProduct(id, numberOfItems, cupSize, sugarLevel, finalPrice)
    }
}