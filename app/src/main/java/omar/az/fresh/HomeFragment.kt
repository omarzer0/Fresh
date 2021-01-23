package omar.az.fresh

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {
    // coffee = 1,  tea = 2,    cream = 3,  freeze = 4
    private var selectedCardViewNumber = 1;
    private var eightDp = 16f;
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eightDp = convertFloatToDp()
        addCardViewListeners()

    }

    private fun addCardViewListeners() {
        coffeeCardView.setOnClickListener {
            if (selectedCardViewNumber != 1) {
                setSelectedStyle(1)
                unSetSelectedStyle(selectedCardViewNumber)
                selectedCardViewNumber = 1
            }
        }
        teaCardView.setOnClickListener {
            if (selectedCardViewNumber != 2) {
                setSelectedStyle(2)
                unSetSelectedStyle(selectedCardViewNumber)
                selectedCardViewNumber = 2
            }
        }
        creamCardView.setOnClickListener {
            if (selectedCardViewNumber != 3) {
                setSelectedStyle(3)
                unSetSelectedStyle(selectedCardViewNumber)
                selectedCardViewNumber = 3
            }
        }
        freezeCardView.setOnClickListener {
            if (selectedCardViewNumber != 4) {
                setSelectedStyle(4)
                unSetSelectedStyle(selectedCardViewNumber)
                selectedCardViewNumber = 4
            }
        }
    }

    private fun setSelectedStyle(newSelectedCardViewNumber: Int) {
        when (newSelectedCardViewNumber) {
            1 -> {
                coffeeCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.mainColor
                    )
                )
                coffeeCardView.cardElevation = 0F
                coffeeTv.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                coffeeImg.setImageResource(R.drawable.ic_coffee_mug_white)
            }

            2 -> {
                teaCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.mainColor
                    )
                )
                teaCardView.cardElevation = 0F
                teaTv.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                teaImg.setImageResource(R.drawable.ic_tea_cup_white)
            }

            3 -> {
                creamCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.mainColor
                    )
                )
                creamCardView.cardElevation = 0F
                creamTv.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                creamImg.setImageResource(R.drawable.ic_ice_cream_white)
            }

            4 -> {
                freezeCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.mainColor
                    )
                )
                freezeCardView.cardElevation = 0F
                freezeTv.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                freezeImg.setImageResource(R.drawable.ic_frappe_white)
            }
        }
    }

    private fun unSetSelectedStyle(oldSelectedCardViewNumber: Int) {
        when (oldSelectedCardViewNumber) {
            1 -> {
                coffeeCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                coffeeCardView.cardElevation = eightDp
                coffeeTv.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                coffeeImg.setImageResource(R.drawable.ic_coffee_mug)
            }

            2 -> {
                teaCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                teaCardView.cardElevation = eightDp
                teaTv.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                teaImg.setImageResource(R.drawable.ic_tea_cup)
            }

            3 -> {
                creamCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                creamCardView.cardElevation = eightDp
                creamTv.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                creamImg.setImageResource(R.drawable.ic_ice_cream)
            }

            4 -> {
                freezeCardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        android.R.color.white
                    )
                )
                freezeCardView.cardElevation = eightDp
                freezeTv.setTextColor(
                    ContextCompat.getColor(
                        (activity as Context),
                        R.color.textDarkSecondary
                    )
                )
                freezeImg.setImageResource(R.drawable.ic_frappe)
            }
        }
    }

    private fun convertFloatToDp() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 8f,
        context?.resources?.displayMetrics
    )

    //fragmentManager?.beginTransaction()?.replace(R.id.mainActivityFrameContainer, ProductDetailsFragment())
//                ?.addToBackStack("f")?.commit()
}