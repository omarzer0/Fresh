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
    val numberOfItems: Int = 0,
    val chosenPrice: Double = 0.0,
    val chosenSugarLevel: Int = 1,
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
)