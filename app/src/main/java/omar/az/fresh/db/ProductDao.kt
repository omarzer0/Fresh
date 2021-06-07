package omar.az.fresh.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import omar.az.fresh.pojo.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Query("UPDATE products SET numberOfItems= :numberOfItems, chosenCupSizeLevel =:cupSize ,chosenSugarLevel=:sugarLevel, finalPrice=:finalPrice WHERE id=:id")
    suspend fun update(
        id: Long,
        numberOfItems: Int,
        cupSize: Int,
        sugarLevel: Int,
        finalPrice: Double
    )

    @Query("DELETE FROM products WHERE id= :id")
    suspend fun delete(id: Long)


    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("SELECT sum(numberOfItems) FROM products")
    fun getNumberOfProductsInCart(): LiveData<Int>

    @Query("SELECT sum(finalPrice) FROM products")
    fun getTotalPrice(): LiveData<Double>
}