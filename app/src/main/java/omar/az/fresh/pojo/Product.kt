package omar.az.fresh.pojo

import androidx.room.PrimaryKey

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
    @PrimaryKey(autoGenerate = true)
    val id: Long = -1
)