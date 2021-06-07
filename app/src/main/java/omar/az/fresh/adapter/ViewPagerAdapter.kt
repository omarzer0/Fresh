package omar.az.fresh.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import omar.az.fresh.R
import omar.az.fresh.ui.home.slider.ViewPagerFragment

class ViewPagerAdapter(manger: FragmentManager) : FragmentPagerAdapter(manger) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ViewPagerFragment(R.drawable.promo_choco)
            1 -> ViewPagerFragment(R.drawable.promo_val)
            2 -> ViewPagerFragment(R.drawable.promo_coffee)
            else -> throw IndexOutOfBoundsException()
        }
    }

    override fun getCount(): Int = 3
}