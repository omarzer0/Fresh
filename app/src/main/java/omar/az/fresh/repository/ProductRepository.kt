package omar.az.fresh.repository

import omar.az.fresh.db.ProductDao
import omar.az.fresh.pojo.Product
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val dao: ProductDao
) {
    suspend fun insertProduct(product: Product) = dao.insert(product)

    suspend fun updateProduct(
        id: Long,
        numberOfItems: Int,
        cupSize: Int,
        sugarLevel: Int,
        finalPrice: Double
    ) = dao.update(id, numberOfItems, cupSize, sugarLevel, finalPrice)

    suspend fun deleteProduct(id: Long) = dao.delete(id)

    fun getAllProducts() = dao.getAllProducts()

    fun getNumberOfProductsInCart() = dao.getNumberOfProductsInCart()

    fun getTotalPrice() = dao.getTotalPrice()
}