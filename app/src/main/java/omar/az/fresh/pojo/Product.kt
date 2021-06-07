package omar.az.fresh.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    val name: String,
    val description: String,
    val imageUrl: Int,
    val backgroundColor: String,
    val smallSizePrice: Double,
    val mediumSizePrice: Double,
    val largeSizePrice: Double,
    var numberOfItems: Int = 1,
    val chosenPrice: Double = smallSizePrice,
    val chosenSugarLevel: Int = 2,
    val chosenCupSizeLevel: Int = 1,
    val finalPrice: Double = 0.0,
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
)