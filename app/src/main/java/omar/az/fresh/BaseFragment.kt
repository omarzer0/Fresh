package omar.az.fresh

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import omar.az.fresh.ui.details.ProductDetailsFragment
import omar.az.fresh.utils.Utils.defaultColorForWhiteBg

@AndroidEntryPoint
open class BaseFragment(private var color: String, layout: Int) : Fragment(layout) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (color.toLowerCase() == "#ffffff" && this is ProductDetailsFragment)
                color = defaultColorForWhiteBg

            val window: Window? = activity?.window
            window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window?.statusBarColor = Color.parseColor(color)
        }
    }


    override fun onDetach() {
        super.onDetach()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window? = activity?.window
            window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window?.statusBarColor = Color.parseColor("#ffffff")
        }
    }
}