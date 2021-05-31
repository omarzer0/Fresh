package omar.az.fresh.ui.cart

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_shopping_cart.*
import omar.az.fresh.BaseFragment
import omar.az.fresh.R
import omar.az.fresh.adapter.ProductAdapter
import omar.az.fresh.ui.details.ProductDetailsFragment
import omar.az.fresh.utils.Utils

class ShoppingCartFragment : BaseFragment(Utils.whiteColor, R.layout.fragment_shopping_cart) {
    private lateinit var productAdapter: ProductAdapter
    private val shoppingCartViewModel: ShoppingCartViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        setClickListeners()
        shoppingCartViewModel.getAllProducts().observe(viewLifecycleOwner, Observer {
            productAdapter.submitList(it)
        })
    }

    private fun setUpRecyclerView() {
        productAdapter = ProductAdapter(true)
        shoppingCartRecyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = null
        }
    }

    private fun setClickListeners() {
        val toast = Toast(activity)
        productAdapter.setOnProductBodyClickListener { product ->
            parentFragmentManager.beginTransaction()
                .add(
                    R.id.mainActivityFrameContainer,
                    ProductDetailsFragment(product, false)
                )
                .addToBackStack("detailFragment").commit()
        }

        productAdapter.setOnRemoveButtonClickListener {
            shoppingCartViewModel.deleteProduct(it)
            toast.apply {
                cancel()
                setText(getString(R.string.deleted_successfully))
                duration = Toast.LENGTH_SHORT
                show()
            }

        }
    }
}