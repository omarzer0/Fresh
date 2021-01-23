package omar.az.fresh

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_product_details.*

class ProductDetailsFragment : Fragment(R.layout.fragment_product_details) {

    private var size = 2
    private var sugarLevel = 2
    private var eightDp = 16f;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eightDp = convertFloatToDp()
        addSugarCardViewListeners()
        addSizeCardViewListeners()
    }

    private fun addSugarCardViewListeners() {
        productDetailsSugar0CardView.setOnClickListener {
            if (sugarLevel != 1) {
                setSelectedStyleForSugarLevel(1)
                unSetSelectedStyleForSugarLevel(sugarLevel)
                sugarLevel = 1
            }
        }
        productDetailsSugar25CardView.setOnClickListener {
            if (sugarLevel != 2) {
                setSelectedStyleForSugarLevel(2)
                unSetSelectedStyleForSugarLevel(sugarLevel)
                sugarLevel = 2
            }
        }
        productDetailsSugar50CardView.setOnClickListener {
            if (sugarLevel != 3) {
                setSelectedStyleForSugarLevel(3)
                unSetSelectedStyleForSugarLevel(sugarLevel)
                sugarLevel = 3
            }
        }
        productDetailsSugar100CardView.setOnClickListener {
            if (sugarLevel != 4) {
                setSelectedStyleForSugarLevel(4)
                unSetSelectedStyleForSugarLevel(sugarLevel)
                sugarLevel = 4
            }
        }
    }

    private fun setSelectedStyleForSugarLevel(newSugarSelectedNumber: Int) {
        when (newSugarSelectedNumber) {
            1 -> {
                productDetailsSugar0CardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.selectedBackground
                    )
                )
                productDetailsSugar0TextTV.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.mainColor
                    )
                )
                productDetailsSugar0CardView.cardElevation = 0f

            }

            2 -> {
                productDetailsSugar25CardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.selectedBackground
                    )
                )
                productDetailsSugar25TextTV.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.mainColor
                    )
                )
                productDetailsSugar25CardView.cardElevation = 0f

            }

            3 -> {

                productDetailsSugar50CardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.selectedBackground
                    )
                )
                productDetailsSugar50TextTV.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.mainColor
                    )
                )
                productDetailsSugar50CardView.cardElevation = 0f

            }

            4 -> {
                productDetailsSugar100CardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.selectedBackground
                    )
                )
                productDetailsSugar100TextTV.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.mainColor
                    )
                )
                productDetailsSugar100CardView.cardElevation = 0f

            }
        }
    }

    private fun unSetSelectedStyleForSugarLevel(oldSugarSelectedNumber: Int) {
        when (oldSugarSelectedNumber) {
            1 -> {
                productDetailsSugar0CardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                productDetailsSugar0TextTV.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                productDetailsSugar0CardView.cardElevation = eightDp
            }

            2 -> {
                productDetailsSugar25CardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                productDetailsSugar25TextTV.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                productDetailsSugar25CardView.cardElevation = eightDp
            }

            3 -> {
                productDetailsSugar50CardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                productDetailsSugar50TextTV.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                productDetailsSugar50CardView.cardElevation = eightDp
            }

            4 -> {
                productDetailsSugar100CardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                productDetailsSugar100TextTV.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                productDetailsSugar100CardView.cardElevation = eightDp
            }
        }
    }

    private fun addSizeCardViewListeners() {
        productDetailsSmallCardView.setOnClickListener {
            if (size != 1) {
                setSelectedStyleForSize(1)
                unSetSelectedStyleForSize(size)
                size = 1
            }
        }
        productDetailsMediumCardView.setOnClickListener {
            if (size != 2) {
                setSelectedStyleForSize(2)
                unSetSelectedStyleForSize(size)
                size = 2
            }
        }
        productDetailsLargeCardView.setOnClickListener {
            if (size != 3) {
                setSelectedStyleForSize(3)
                unSetSelectedStyleForSize(size)
                size = 3
            }
        }
    }

    private fun setSelectedStyleForSize(newSizeSelectedNumber: Int) {
        when (newSizeSelectedNumber) {
            1 -> {
                productDetailsSmallCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.selectedBackground
                    )
                )
                productDetailsSmallTextTitle.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.secondaryColor
                    )
                )
                productDetailsSmallTextML.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.secondaryColor
                    )
                )
                productDetailsSmallCardView.elevation = 0f
                productDetailsSmallImage.setImageResource(R.drawable.ic_frappe_main_color)
            }

            2 -> {
                productDetailsMediumCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.selectedBackground
                    )
                )
                productDetailsMediumTextTitle.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.secondaryColor
                    )
                )
                productDetailsMediumTextML.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.secondaryColor
                    )
                )
                productDetailsMediumCardView.elevation = 0f
                productDetailsMediumImage.setImageResource(R.drawable.ic_frappe_main_color)
            }

            3 -> {
                productDetailsLargeCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.selectedBackground
                    )
                )
                productDetailsLargeTextTitle.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.secondaryColor
                    )
                )
                productDetailsLargeTextML.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.secondaryColor
                    )
                )
                productDetailsLargeCardView.elevation = 0f
                productDetailsLargeImage.setImageResource(R.drawable.ic_frappe_main_color)
            }

        }
    }

    private fun unSetSelectedStyleForSize(oldSizeSelectedNumber: Int) {
        when (oldSizeSelectedNumber) {
            1 -> {
                productDetailsSmallCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                productDetailsSmallTextTitle.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                productDetailsSmallTextML.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                productDetailsSmallCardView.elevation = eightDp
                productDetailsSmallImage.setImageResource(R.drawable.ic_frappe)
            }

            2 -> {
                productDetailsMediumCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                productDetailsMediumTextTitle.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                productDetailsMediumTextML.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                productDetailsMediumCardView.elevation = eightDp
                productDetailsMediumImage.setImageResource(R.drawable.ic_frappe)
            }

            3 -> {
                productDetailsLargeCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                productDetailsLargeTextTitle.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                productDetailsLargeTextML.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                productDetailsLargeCardView.elevation = eightDp
                productDetailsLargeImage.setImageResource(R.drawable.ic_frappe)
            }
        }
    }

    private fun convertFloatToDp() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 8f,
        context?.resources?.displayMetrics
    )
}