package omar.az.fresh.repository

import omar.az.fresh.db.ProductDatabase
import omar.az.fresh.pojo.Product

class ProductRepository(private val db: ProductDatabase) {
    suspend fun insertProduct(product: Product) = db.getArticleDao().insert(product)

    fun getAllProducts() = db.getArticleDao().getAllProducts()
}