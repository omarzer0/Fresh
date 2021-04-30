package omar.az.fresh.pojo

import android.graphics.Color

data class Product(
    val id: Long,
    val name: String,
    val description: String,
    val image: Int,
    val backgroundColor : String,
    val smallPrice: Double,
    val mediumPrice: Double,
    val largePrice: Double,
    val numberOfItems: Int = 0
)