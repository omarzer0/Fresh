package omar.az.fresh.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "products")
data class Product(
    val name: String,
    val description: String,
    val image: Int,
    val backgroundColor: String,
    val smallPrice: Double,
    val mediumPrice: Double,
    val largePrice: Double,
    var numberOfItems: Int = 1,
    val chosenPrice: Double = smallPrice,
    val chosenSugarLevel: Int = 2,
    val chosenCupSizeLevel: Int = 1,
    val finalPrice: Double = 0.0,
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
)