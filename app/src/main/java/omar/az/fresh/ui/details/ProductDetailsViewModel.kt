package omar.az.fresh.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductDetailsViewModel : ViewModel() {
    val choiceSize: MutableLiveData<Int> = MutableLiveData(2)

}