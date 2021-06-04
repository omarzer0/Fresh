package omar.az.fresh.ui.details

import android.content.Context
import android.graphics.Color
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
import kotlinx.android.synthetic.main.fragment_product_details.*
import omar.az.fresh.BaseFragment
import omar.az.fresh.R
import omar.az.fresh.pojo.Product
import omar.az.fresh.utils.Utils


class ProductDetailsFragment(private val product: Product, private val isInsert: Boolean) :
    BaseFragment(product.backgroundColor, R.layout.fragment_product_details), View.OnClickListener {

    private val detailsViewModel: ProductDetailsViewModel by viewModels()


    private var oldChoiceSize = 2
    private var oldSugarLevelChoice = 2
    private var eightDp = 16f

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        setDataToViews()
        eightDp = convertFloatToDp()
        addClickListeners()

        detailsViewModel.choiceSize.observe(viewLifecycleOwner, Observer {
            productDetailsPriceTV.text =
                (detailsViewModel.tempInputNumber.value?.times(getPriceText(it))).toString()
        })


        detailsViewModel.tempInputNumber.observe(viewLifecycleOwner, Observer { itemCount ->
            productDetailsPriceTV.text = (itemCount.times(getPriceText(oldChoiceSize))).toString()
        })


    }

    private fun getPriceText(size: Int): Double =
        when (size) {
            1 -> (product.smallPrice)
            2 -> (product.mediumPrice)
            3 -> (product.largePrice)
            else -> 0.0
        }


    private fun setDataToViews() {
        productDetailsImage.setImageResource(product.image)
        productDetailsNameTV.text = product.name
        productDetailsPriceTV.text = product.finalPrice.toString()
        productDetailsQuantityTextTV.text = product.numberOfItems.toString()
        detailsViewModel.tempInputNumber.postValue(product.numberOfItems)
        oldChoiceSize = product.chosenCupSizeLevel
        setSizeCardListener(oldChoiceSize)
        setSugarCardListener(product.chosenSugarLevel)
        cl_details_fragment_root_view.setBackgroundColor(
            Color.parseColor(product.backgroundColor)
        )

        if (isInsert) addToCardBtn.text = getString(R.string.add_to_cart)
        else addToCardBtn.text = getText(R.string.edit_item)
    }


    private fun convertFloatToDp() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 8f,
        context?.resources?.displayMetrics
    )

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.productDetailsSmallCardView -> setSizeCardListener(1)
            R.id.productDetailsMediumCardView -> setSizeCardListener(2)
            R.id.productDetailsLargeCardView -> setSizeCardListener(3)

            R.id.productDetailsSugar0CardView -> setSugarCardListener(1)
            R.id.productDetailsSugar25CardView -> setSugarCardListener(2)
            R.id.productDetailsSugar50CardView -> setSugarCardListener(3)
            R.id.productDetailsSugar100CardView -> setSugarCardListener(4)

            R.id.addToCardBtn -> addToCart()
            R.id.productDetailsQuantityPlusBTN -> increaseItem()
            R.id.productDetailsQuantityMinusBTN -> decreaseItem()

        }
    }


    private fun addToCart() {
        var toastMessage = ""
        val numberOfItems: Int = productDetailsQuantityTextTV.text.toString().toInt()
        val chosenPrice: Double = productDetailsPriceTV.text.toString().toDouble()

        if (isInsert) {
            val tempProduct = Product(
                product.name,
                product.description,
                product.image,
                product.backgroundColor,
                product.smallPrice,
                product.mediumPrice,
                product.largePrice,
                numberOfItems,
                chosenPrice,
                oldSugarLevelChoice,
                oldChoiceSize,
                (numberOfItems * getPriceText(oldChoiceSize))
            )
            detailsViewModel.insertProduct(tempProduct)
            toastMessage = getString(R.string.added_successfully)
        } else {
            detailsViewModel.updateProduct(
                product.id ?: -1,
                numberOfItems,
                oldChoiceSize,
                oldSugarLevelChoice,
                (numberOfItems * getPriceText(oldChoiceSize))
            )
            toastMessage = getString(R.string.edited_successfully)
        }
        activity?.let { activity ->
            Utils.showMyToast(activity, toastMessage)
        }
        parentFragmentManager.popBackStack()
    }

    private fun increaseItem() {
        var temp = productDetailsQuantityTextTV.text.toString().toInt()
        temp++
        productDetailsQuantityTextTV.text = temp.toString()
        detailsViewModel.tempInputNumber.postValue(temp)
    }

    private fun decreaseItem() {
        var temp = productDetailsQuantityTextTV.text.toString().toInt()
        if (temp > 1) {
            temp--
            productDetailsQuantityTextTV.text = temp.toString()
            detailsViewModel.tempInputNumber.postValue(temp)
        }
    }

    private fun addClickListeners() {
        productDetailsSmallCardView.setOnClickListener(this)
        productDetailsMediumCardView.setOnClickListener(this)
        productDetailsLargeCardView.setOnClickListener(this)

        productDetailsSugar0CardView.setOnClickListener(this)
        productDetailsSugar25CardView.setOnClickListener(this)
        productDetailsSugar50CardView.setOnClickListener(this)
        productDetailsSugar100CardView.setOnClickListener(this)

        addToCardBtn.setOnClickListener(this)
        productDetailsQuantityPlusBTN.setOnClickListener(this)
        productDetailsQuantityMinusBTN.setOnClickListener(this)
    }

    private fun setSizeCardListener(selectedNumber: Int) {
        unSetSelectedSizeCardStyle(oldChoiceSize)
        setSelectedSizeCardStyle(selectedNumber)
        oldChoiceSize = selectedNumber
    }


    private fun unSetSelectedSizeCardStyle(oldSelectedSizeCardViewNumber: Int) {
        when (oldSelectedSizeCardViewNumber) {
            1 -> unSelectedSizeCard(
                productDetailsSmallCardView,
                productDetailsSmallImage,
                productDetailsSmallTextTitle,
                productDetailsSmallTextML
            )

            2 -> unSelectedSizeCard(
                productDetailsMediumCardView,
                productDetailsMediumImage,
                productDetailsMediumTextTitle,
                productDetailsMediumTextML
            )
            3 -> unSelectedSizeCard(
                productDetailsLargeCardView,
                productDetailsLargeImage,
                productDetailsLargeTextTitle,
                productDetailsLargeTextML
            )
        }
    }

    private fun unSelectedSizeCard(
        cardView: CardView,
        imageView: ImageView,
        title: TextView,
        mlText: TextView
    ) {

        cardView.setCardBackgroundColor(
            ContextCompat.getColor(
                (activity as Context),
                android.R.color.white
            )
        )
        title.setTextColor(
            ContextCompat.getColor(
                (activity as Context),
                R.color.textDarkSecondary
            )
        )
        mlText.setTextColor(
            ContextCompat.getColor(
                (activity as Context),
                R.color.textDarkSecondary
            )
        )
        cardView.elevation = eightDp
        imageView.setImageResource(R.drawable.ic_frappe)

    }


    private fun setSelectedSizeCardStyle(newSelectedSizeCardViewNumber: Int) {
        when (newSelectedSizeCardViewNumber) {
            1 -> selectedSizeCard(
                productDetailsSmallCardView,
                productDetailsSmallImage,
                productDetailsSmallTextTitle,
                productDetailsSmallTextML, 1
            )

            2 -> selectedSizeCard(
                productDetailsMediumCardView,
                productDetailsMediumImage,
                productDetailsMediumTextTitle,
                productDetailsMediumTextML, 2
            )
            3 -> selectedSizeCard(
                productDetailsLargeCardView,
                productDetailsLargeImage,
                productDetailsLargeTextTitle,
                productDetailsLargeTextML, 3
            )
        }
    }

    private fun selectedSizeCard(
        cardView: CardView,
        imageView: ImageView,
        title: TextView,
        mlText: TextView,
        selectedSize: Int
    ) {

        cardView.setCardBackgroundColor(
            ContextCompat.getColor(
                (activity as Context),
                R.color.selectedBackground
            )
        )
        title.setTextColor(
            ContextCompat.getColor(
                (activity as Context),
                R.color.secondaryColor
            )
        )
        mlText.setTextColor(
            ContextCompat.getColor(
                (activity as Context),
                R.color.secondaryColor
            )
        )
        cardView.elevation = 0f
        imageView.setImageResource(R.drawable.ic_frappe_main_color)
        oldChoiceSize = selectedSize
        detailsViewModel.choiceSize.postValue(selectedSize)
    }


    private fun setSugarCardListener(selectedNumber: Int) {
        unSelectedSugarCardStyle(oldSugarLevelChoice)
        selectedSugarCardStyle(selectedNumber)
        oldSugarLevelChoice = selectedNumber
    }

    private fun unSelectedSugarCardStyle(oldSugarSelectedNumber: Int) {
        when (oldSugarSelectedNumber) {
            1 -> unSelectedSugarCard(productDetailsSugar0CardView, productDetailsSugar0TextTV)
            2 -> unSelectedSugarCard(productDetailsSugar25CardView, productDetailsSugar25TextTV)
            3 -> unSelectedSugarCard(productDetailsSugar50CardView, productDetailsSugar50TextTV)
            4 -> unSelectedSugarCard(productDetailsSugar100CardView, productDetailsSugar100TextTV)
        }
    }

    private fun unSelectedSugarCard(cardView: CardView, textView: TextView) {
        cardView.setCardBackgroundColor(
            ContextCompat.getColor(
                (activity as Context),
                android.R.color.white
            )
        )
        textView.setTextColor(
            ContextCompat.getColor(
                (activity as Context),
                R.color.textDarkSecondary
            )
        )
        cardView.cardElevation = eightDp
    }

    private fun selectedSugarCardStyle(oldSugarSelectedNumber: Int) {
        when (oldSugarSelectedNumber) {
            1 -> selectedSugarCard(productDetailsSugar0CardView, productDetailsSugar0TextTV)
            2 -> selectedSugarCard(productDetailsSugar25CardView, productDetailsSugar25TextTV)
            3 -> selectedSugarCard(productDetailsSugar50CardView, productDetailsSugar50TextTV)
            4 -> selectedSugarCard(productDetailsSugar100CardView, productDetailsSugar100TextTV)
        }
    }

    private fun selectedSugarCard(cardView: CardView, textView: TextView) {
        cardView.setCardBackgroundColor(
            ContextCompat.getColor(
                (activity as Context),
                R.color.selectedBackground
            )
        )
        textView.setTextColor(
            ContextCompat.getColor(
                (activity as Context),
                R.color.mainColor
            )
        )
        cardView.cardElevation = 0f
    }

}