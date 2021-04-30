package omar.az.fresh.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_item.view.*
import omar.az.fresh.R
import omar.az.fresh.pojo.Product

class ProductAdapter(private val isInDetailsFragment: Boolean) :
    ListAdapter<Product, ProductAdapter.ProductViewHolder>(diffUtilCallback()) {


    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.itemView.apply {
            productItemCardViewBackgroundCV
                .setCardBackgroundColor(Color.parseColor(currentItem.backgroundColor))

            productImageImg.setImageResource(currentItem.image)
            productNameTV.text = currentItem.name
            productDescriptionTV.text = currentItem.description
            productPriceTV.text = currentItem.smallPrice.toString()
            setOnClickListener { onProductBodyClickListener?.let { it(currentItem) } }

            if (isInDetailsFragment) {
                productCartQuantityViewLL.visibility = View.VISIBLE
            } else {
                productAddButton.visibility = View.VISIBLE
                productAddButton.setOnClickListener {
                    onProductAddButtonClickListener?.let {
                        it(
                            currentItem
                        )
                    }
                }
            }
        }
    }

    private var onProductBodyClickListener: ((Product) -> Unit)? = null
    private var onProductAddButtonClickListener: ((Product) -> Unit)? = null

    fun setOnProductBodyClickListener(listener: (Product) -> Unit) {
        onProductBodyClickListener = listener
    }

    fun setOnAddButtonClickListener(listener: (Product) -> Unit) {
        onProductAddButtonClickListener = listener
    }
}

fun diffUtilCallback(): ItemCallback<Product> = object : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product) =
        oldItem.name + oldItem.description == newItem.name + newItem.description

    override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem

}

