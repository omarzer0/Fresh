package omar.az.fresh.db

import android.content.Context
import androidx.room.*
import omar.az.fresh.pojo.Product
import omar.az.fresh.utils.Utils.DATABASE_NAME

@Database(entities = [Product::class], version = 1)
// class not java class as it is a kotlin class not java (what an error!!)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDao

//    // singleton approach as usual
//    companion object {
//        @Volatile
//        // volatile means other threads can know about changes happens
//        private var instance: ProductDatabase? = null
//        private val LOCK = Any()
//
//        // sync means only one thread can access the db at a time and
//        // any other thread must wait till the previous thread finishes
//        // invoke means the object with invoke can be called as a function
//        // like 1() or hi() and do what ever
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            // now if instance is null only then init it or return the existing instance
//            instance ?: createDatabase(context).also { init ->
//                instance = init
//            }
//        }
//
//        private fun createDatabase(context: Context) = Room.databaseBuilder(
//            context.applicationContext,
//            ProductDatabase::class.java,
//            DATABASE_NAME
//        ).build()
//
//    }
}