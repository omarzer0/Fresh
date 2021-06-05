package omar.az.fresh.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import omar.az.fresh.R
import omar.az.fresh.pojo.Product
import omar.az.fresh.repository.ProductRepository
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {
    //    private val productRepository = ProductRepository(ProductDatabase(application))
    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>>
        get() = _productList

    fun getNumberOfProductsInCart() = productRepository.getNumberOfProductsInCart()

    init {
        _productList.postValue(coffeeList)

    }


    fun getListOfProducts(productListId: Int) {
        when (productListId) {
            1 -> _productList.postValue(coffeeList)
            2 -> _productList.postValue(teaList)
            3 -> _productList.postValue(creamList)
            4 -> _productList.postValue(freezeList)
        }
    }


}


private val coffeeList = List(100) {
    Product(
        "coffee cup drink",
        "description",
        R.drawable.lavender,
        "#BCF8BC",
        6.50,
        9.0,
        12.0
    )
}

private val teaList = List(100) {
    Product(
        "tea",
        "description",
        R.drawable.lavender,
        "#BCF8BC",
        6.50,
        9.0,
        12.0
    )
}
private val creamList = List(100) {
    Product(
        "cream",
        "description",
        R.drawable.lavender,
        "#BCF8BC",
        6.50,
        9.0,
        12.0
    )
}
private val freezeList = List(100) {
    Product(
        "freeze",
        "description",
        R.drawable.lavender,
        "#BCF8BC",
        6.50,
        9.0,
        12.0
    )
}