package omar.az.fresh.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import omar.az.fresh.R

object Utils {
    const val DATABASE_NAME = "Product.db"
    const val whiteColor = "#FFFFFF"
    private var mToast: Toast? = null

    fun showMyToast(context: Context, text: String) {
        mToast?.cancel()
        mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
        mToast?.show()
    }

    fun transitionFragment(
        parentFragmentManager: FragmentManager,
        fragment: Fragment,
        stackName: String
    ) {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            .add(
                R.id.mainActivityFrameContainer,
                fragment
            ).addToBackStack(stackName).commit()
    }
}