package omar.az.fresh.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import omar.az.fresh.ProductDetailsFragment
import omar.az.fresh.R
import omar.az.fresh.ShoppingCartFragment
import omar.az.fresh.adapter.ProductAdapter


class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener {
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

        setSelectedStyle(previousSelectedCardViewNumber)

        homeFragmentViewModel.productList.observe(viewLifecycleOwner, Observer {
            productAdapter.submitList(it)
        })

    }


    private fun addCardViewListeners() {
        coffeeCardView.setOnClickListener(this)
        teaCardView.setOnClickListener(this)
        creamCardView.setOnClickListener(this)
        freezeCardView.setOnClickListener(this)
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

        }

        productAdapter.setOnAddButtonClickListener { product ->
//            Toast.makeText(context, "button", Toast.LENGTH_SHORT).show()
            fragmentManager?.beginTransaction()
                ?.add(
                    R.id.mainActivityFrameContainer,
                    ProductDetailsFragment(product)
                )
                ?.addToBackStack("f")?.commit()
        }

        shoppingCartImg.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(
                    R.id.mainActivityFrameContainer,
                    ShoppingCartFragment()
                )
                ?.addToBackStack("f")?.commit()
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
//        setRecyclerViewData(newData)
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