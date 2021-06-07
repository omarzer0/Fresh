package omar.az.fresh.ui.home.slider

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_view_pager.*
import omar.az.fresh.BaseFragment
import omar.az.fresh.R
import omar.az.fresh.utils.Utils

class ViewPagerFragment(private val image: Int?) :
    BaseFragment(Utils.whiteColor, R.layout.fragment_view_pager) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image?.let { iv_slider.setImageDrawable(resources.getDrawable(image)) }
    }
}