package omar.az.fresh.db

import androidx.lifecycle.LiveData
import androidx.room.*
import omar.az.fresh.pojo.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // the return type is the id of the inserted item
    suspend fun insert(product: Product)

    //
//    // room query not retrofit ;)
//    // get all articles stored in room db
//    // it returns a liveData
    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>
//
//    @Delete
//    suspend fun deleteArticle(article: Article)
}