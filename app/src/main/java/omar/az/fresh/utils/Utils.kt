package omar.az.fresh.utils

import android.content.Context
import android.widget.Toast

object Utils {
    const val whiteColor = "#FFFFFF"
    private var mToast : Toast? = null

    fun showMyToast(context: Context, text:String){
        mToast?.cancel()
        mToast = Toast.makeText(context,text, Toast.LENGTH_SHORT)
        mToast?.show()
    }
}