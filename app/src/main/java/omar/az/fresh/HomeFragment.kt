package omar.az.fresh

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    //fragmentManager?.beginTransaction()?.replace(R.id.mainActivityFrameContainer, ProductDetailsFragment())
//                ?.addToBackStack("f")?.commit()
}