package omar.az.fresh.pojo

data class Product(
    val id: Long,
    val name: String,
    val description: String,
    val image: Int,
    val smallPrice: Double,
    val mediumPrice: Double,
    val largePrice: Double,
    val numberOfItems: Int = 0
)