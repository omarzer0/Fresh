package omar.az.fresh.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import omar.az.fresh.R
import omar.az.fresh.pojo.Product
import omar.az.fresh.repository.ProductRepository
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

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


private val coffeeList = listOf(
    Product(
        "Black Coffee",
        "Really tasty black coffee",
        R.drawable.coffee1,
        "#a58faa",
        11.50,
        14.0,
        16.0
    ), Product(
        "Cappuccino",
        "Single espresso shot and hot milk",
        R.drawable.coffee2,
        "#ededd0",
        9.00,
        10.0,
        12.0
    ), Product(
        "Coffee Cup",
        "Sweet Hot coffee",
        R.drawable.coffee3,
        "#deedf0",
        13.50,
        15.0,
        20.0
    ), Product(
        "Black Coffee",
        "Really tasty black coffee",
        R.drawable.coffee1,
        "#a58faa",
        11.50,
        14.0,
        16.0
    ), Product(
        "Cappuccino",
        "Single espresso shot and hot milk",
        R.drawable.coffee2,
        "#ededd0",
        9.00,
        10.0,
        12.0
    ), Product(
        "Coffee Cup",
        "Sweet Hot coffee",
        R.drawable.coffee3,
        "#deedf0",
        13.50,
        15.0,
        20.0
    ), Product(
        "Black Coffee",
        "Really tasty black coffee",
        R.drawable.coffee1,
        "#a58faa",
        11.50,
        14.0,
        16.0
    ), Product(
        "Cappuccino",
        "Single espresso shot and hot milk",
        R.drawable.coffee2,
        "#ededd0",
        9.00,
        10.0,
        12.0
    ), Product(
        "Coffee Cup",
        "Sweet Hot coffee",
        R.drawable.coffee3,
        "#deedf0",
        13.50,
        15.0,
        20.0
    )
)
private val teaList = listOf(
    Product(
        "Lavender Milk",
        "Really great as an ice tea",
        R.drawable.lavender,
        "#BCF8BC",
        6.50,
        9.0,
        12.0
    ), Product(
        "coffee cup drink",
        "description",
        R.drawable.lavender,
        "#BCF8BC",
        6.50,
        9.0,
        12.0
    ), Product(
        "coffee cup drink",
        "description",
        R.drawable.lavender,
        "#BCF8BC",
        6.50,
        9.0,
        12.0
    )
)
private val creamList = listOf(
    Product(
        "Aloha Pineapple",
        "pineapple sherbet strawberries bananas nonfat Greek yogurt",
        R.drawable.cream1,
        "#fc5404",
        10.50,
        14.0,
        16.0
    ), Product(
        "Gelato",
        "Gelato choco ice cream",
        R.drawable.cream5,
        "#C9ADFF",
        9.50,
        13.0,
        18.0
    ), Product(
        "Almond Chocolate Coconut",
        "Almond delicious ice cream cup",
        R.drawable.cream4,
        "#907fa4",
        11.0,
        14.0,
        19.0
    ), Product(
        "Aloha Pineapple",
        "pineapple sherbet strawberries bananas nonfat Greek yogurt",
        R.drawable.cream1,
        "#fc5404",
        10.50,
        14.0,
        16.0
    ), Product(
        "Gelato",
        "Gelato choco ice cream",
        R.drawable.cream5,
        "#C9ADFF",
        9.50,
        13.0,
        18.0
    ), Product(
        "Almond Chocolate Coconut",
        "Almond delicious ice cream cup",
        R.drawable.cream4,
        "#907fa4",
        11.0,
        14.0,
        19.0
    ), Product(
        "Aloha Pineapple",
        "pineapple sherbet strawberries bananas nonfat Greek yogurt",
        R.drawable.cream1,
        "#fc5404",
        10.50,
        14.0,
        16.0
    ), Product(
        "Gelato",
        "Gelato choco ice cream",
        R.drawable.cream5,
        "#C9ADFF",
        9.50,
        13.0,
        18.0
    ), Product(
        "Almond Chocolate Coconut",
        "Almond delicious ice cream cup",
        R.drawable.cream4,
        "#907fa4",
        11.0,
        14.0,
        19.0
    )
)
private val freezeList = listOf(
    Product(
        "Lavender Milk",
        "Really great as an ice tea",
        R.drawable.lavender,
        "#BCF8BC",
        6.50,
        9.0,
        12.0
    ), Product(
        "Strawberry",
        "Fresh fruit juice that is full of vitamin C and antioxidants",
        R.drawable.freeze1,
        "#ff0000",
        7.50,
        9.0,
        12.0
    ), Product(
        "Guava juice",
        "Sweet and savoury guava juice",
        R.drawable.freeze3,
        "#ff669900",
        6.00,
        9.0,
        12.0
    ), Product(
        "Orange Juice",
        "Really great taste orange juice",
        R.drawable.freeze2,
        "#f7adb0",
        8.00,
        9.0,
        12.0
    ), Product(
        "Lavender Milk",
        "Really great as an ice tea",
        R.drawable.lavender,
        "#BCF8BC",
        6.50,
        9.0,
        12.0
    ), Product(
        "Strawberry",
        "Fresh fruit juice that is full of vitamin C and antioxidants",
        R.drawable.freeze1,
        "#ff0000",
        7.50,
        9.0,
        12.0
    ), Product(
        "Guava juice",
        "Sweet and savoury guava juice",
        R.drawable.freeze3,
        "#ff669900",
        6.00,
        9.0,
        12.0
    ), Product(
        "Orange Juice",
        "Really great taste orange juice",
        R.drawable.freeze2,
        "#f7adb0",
        8.00,
        9.0,
        12.0
    ), Product(
        "Lavender Milk",
        "Really great as an ice tea",
        R.drawable.lavender,
        "#BCF8BC",
        6.50,
        9.0,
        12.0
    ), Product(
        "Strawberry",
        "Fresh fruit juice that is full of vitamin C and antioxidants",
        R.drawable.freeze1,
        "#ff0000",
        7.50,
        9.0,
        12.0
    ), Product(
        "Guava juice",
        "Sweet and savoury guava juice",
        R.drawable.freeze3,
        "#ff669900",
        6.00,
        9.0,
        12.0
    ), Product(
        "Orange Juice",
        "Really great taste orange juice",
        R.drawable.freeze2,
        "#f7adb0",
        8.00,
        9.0,
        12.0
    )
)