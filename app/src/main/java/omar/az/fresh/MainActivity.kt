package omar.az.fresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import omar.az.fresh.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.mainActivityFrameContainer,
            HomeFragment()
        ).commit()
    }
}