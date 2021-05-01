package omar.az.fresh.ui.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_shopping_cart.*
import omar.az.fresh.R
import omar.az.fresh.adapter.ProductAdapter
import omar.az.fresh.db.ProductDatabase
import omar.az.fresh.repository.ProductRepository

class ShoppingCartFragment : Fragment(R.layout.fragment_shopping_cart) {
    private lateinit var productAdapter: ProductAdapter
    private val shoppingCartViewModel: ShoppingCartViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        shoppingCartViewModel.getAllProducts().observe(viewLifecycleOwner, Observer {
            productAdapter.submitList(it)
        })
    }

    fun setUpRecyclerView() {
        productAdapter = ProductAdapter(true)
        shoppingCartRecyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = null
        }
    }
}