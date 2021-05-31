package omar.az.fresh.repository

import omar.az.fresh.db.ProductDatabase
import omar.az.fresh.pojo.Product

class ProductRepository(private val db: ProductDatabase) {
    suspend fun insertProduct(product: Product) = db.getArticleDao().insert(product)

    suspend fun updateProduct(id: Long, numberOfItems: Int, cupSize: Int, sugarLevel: Int ,finalPrice:Double)
    = db.getArticleDao().update(id, numberOfItems,cupSize,sugarLevel,finalPrice)

    suspend fun deleteProduct(id: Long) = db.getArticleDao().delete(id)

    fun getAllProducts() = db.getArticleDao().getAllProducts()

    fun getNumberOfProductsInCart() = db.getArticleDao().getNumberOfProductsInCart()
}