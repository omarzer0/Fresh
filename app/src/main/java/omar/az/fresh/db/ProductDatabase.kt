package omar.az.fresh.db

import androidx.room.Database
import androidx.room.RoomDatabase
import omar.az.fresh.pojo.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDao
}