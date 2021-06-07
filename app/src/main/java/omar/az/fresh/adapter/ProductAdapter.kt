package omar.az.fresh.adapter

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

class ProductAdapter(private val fromCartFragment: Boolean) :
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

            productImageImg.setImageResource(currentItem.imageUrl)
            productNameTV.text = currentItem.name
            productDescriptionTV.text = currentItem.description

            setOnClickListener { onProductBodyClickListener?.let { it(currentItem) } }

            if (fromCartFragment) {
                productRemoveItemButton.visibility = View.VISIBLE
                tv_number_of_items_cart_fragment.text = "${currentItem.numberOfItems}"
                tv_hashtag_cart_fragment.visibility = View.VISIBLE

                if (currentItem.backgroundColor.toLowerCase() != "#ffffff"){
                    val color = Color.parseColor(currentItem.backgroundColor)
                    tv_number_of_items_cart_fragment.setTextColor(color)
                    tv_hashtag_cart_fragment.setTextColor(color)
                    productPriceTV.setTextColor(color)
                    tv_dollar_sign.setTextColor(color)
                }

                productPriceTV.text = currentItem.finalPrice.toString()
                cl_root_view.setOnClickListener {
                    onProductBodyClickListener?.let {
                        it(currentItem)
                    }
                }

                productRemoveItemButton.setOnClickListener {
                    onProductRemoveButtonClickListener?.let { it(currentItem.id!!) }
                }

            } else {
                productAddButton.visibility = View.VISIBLE
                productPriceTV.text = currentItem.chosenPrice.toString()
                productAddButton.setOnClickListener {
                    onProductBodyClickListener?.let {
                        it(currentItem)
                    }
                }
            }
        }
    }

    private var onProductBodyClickListener: ((Product) -> Unit)? = null
    private var onProductRemoveButtonClickListener: ((Long) -> Unit)? = null

    fun setOnProductBodyClickListener(listener: (Product) -> Unit) {
        onProductBodyClickListener = listener
    }

    fun setOnRemoveButtonClickListener(listener: (Long) -> Unit) {
        onProductRemoveButtonClickListener = listener
    }
}

fun diffUtilCallback(): ItemCallback<Product> = object : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem

}

