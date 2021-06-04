package omar.az.fresh.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import omar.az.fresh.BaseFragment
import omar.az.fresh.R
import omar.az.fresh.adapter.ProductAdapter
import omar.az.fresh.adapter.ViewPagerAdapter
import omar.az.fresh.ui.cart.ShoppingCartFragment
import omar.az.fresh.ui.details.ProductDetailsFragment
import omar.az.fresh.utils.Utils


class HomeFragment : BaseFragment(Utils.whiteColor, R.layout.fragment_home), View.OnClickListener {
    // coffee = 1,  tea = 2,    cream = 3,  freeze = 4
    private val homeFragmentViewModel: HomeFragmentViewModel by viewModels()
    private var previousSelectedCardViewNumber = 1
    private var eightDp = 16f
    private lateinit var productAdapter: ProductAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eightDp = convertFloatToDp()

        addCardViewListeners()
        setRecyclerView()
        setClickListeners()
        setUpSlider()

        setSelectedStyle(previousSelectedCardViewNumber)

        homeFragmentViewModel.productList.observe(viewLifecycleOwner, Observer {
            productAdapter.submitList(it)
        })

        homeFragmentViewModel.getNumberOfProductsInCart().observe(viewLifecycleOwner, Observer {
            if (it != null && it > 0) {
                cartBadge.visibility = View.VISIBLE
                cartBadge.text = "$it"
            } else cartBadge.visibility = View.INVISIBLE
        })

    }


    private fun addCardViewListeners() {
        coffeeCardView.setOnClickListener(this)
        teaCardView.setOnClickListener(this)
        creamCardView.setOnClickListener(this)
        freezeCardView.setOnClickListener(this)
    }

    private fun setUpSlider() {
        val viewPagerAdapter = ViewPagerAdapter(parentFragmentManager)
        val tabLayout = tab_dots
        val viewPager = pager
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setRecyclerView() {
        productAdapter = ProductAdapter(false)
        rv_home_fragment.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = null
        }
    }

    private fun setClickListeners() {
        productAdapter.setOnProductBodyClickListener { product ->
            Utils.transitionFragment(
                parentFragmentManager, ProductDetailsFragment(product, true), "detailsFragment"
            )
        }

        shoppingCartImg.setOnClickListener {
            Utils.transitionFragment(
                parentFragmentManager, ShoppingCartFragment(), "detailsFragment"
            )
        }
    }

    private fun setCardClickListener(selectedNumber: Int) {
        unSetSelectedStyle(previousSelectedCardViewNumber)
        setSelectedStyle(selectedNumber)
        previousSelectedCardViewNumber = selectedNumber
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.coffeeCardView -> setCardClickListener(1)
            R.id.teaCardView -> setCardClickListener(2)
            R.id.creamCardView -> setCardClickListener(3)
            R.id.freezeCardView -> setCardClickListener(4)
        }
    }


    private fun selectCard(
        cardView: CardView,
        imageView: ImageView,
        image: Int,
        textView: TextView,
        productListId: Int
    ) {
        cardView.setCardBackgroundColor(
            ContextCompat.getColor(
                (activity as Context),
                R.color.mainColor
            )
        )
        cardView.cardElevation = 0F
        textView.setTextColor(
            ContextCompat.getColor(
                (activity as Context),
                android.R.color.white
            )
        )
        imageView.setImageResource(image)
        homeFragmentViewModel.getListOfProducts(productListId)
    }

    private fun setSelectedStyle(newSelectedCardViewNumber: Int) {
        when (newSelectedCardViewNumber) {
            1 -> selectCard(
                coffeeCardView,
                coffeeImg,
                R.drawable.ic_coffee_mug_white,
                coffeeTv, 1
            )

            2 -> selectCard(
                teaCardView, teaImg,
                R.drawable.ic_tea_cup_white, teaTv, 2
            )

            3 -> selectCard(
                creamCardView,
                creamImg,
                R.drawable.ic_ice_cream_white,
                creamTv, 3
            )

            4 -> selectCard(
                freezeCardView,
                freezeImg,
                R.drawable.ic_frappe_white,
                freezeTv, 4
            )
        }
    }

    private fun unSelectCard(
        cardView: CardView,
        imageView: ImageView,
        image: Int,
        textView: TextView
    ) {
        cardView.setCardBackgroundColor(
            ContextCompat.getColor(
                (activity as Context),
                android.R.color.white
            )
        )
        cardView.cardElevation = eightDp
        textView.setTextColor(
            ContextCompat.getColor(
                (activity as Context),
                R.color.textDarkSecondary
            )
        )
        imageView.setImageResource(image)
    }

    private fun unSetSelectedStyle(oldSelectedCardViewNumber: Int) {
        when (oldSelectedCardViewNumber) {
            1 -> unSelectCard(
                coffeeCardView, coffeeImg,
                R.drawable.ic_coffee_mug, coffeeTv
            )
            2 -> unSelectCard(
                teaCardView, teaImg,
                R.drawable.ic_tea_cup, teaTv
            )
            3 -> unSelectCard(
                creamCardView, creamImg,
                R.drawable.ic_ice_cream, creamTv
            )
            4 -> unSelectCard(
                freezeCardView, freezeImg,
                R.drawable.ic_frappe, freezeTv
            )
        }
    }

    private fun convertFloatToDp() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 8f,
        context?.resources?.displayMetrics
    )
}