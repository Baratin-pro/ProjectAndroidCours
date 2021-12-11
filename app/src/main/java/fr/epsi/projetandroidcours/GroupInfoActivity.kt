package fr.epsi.projetandroidcours

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GroupInfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_info)
        setHeaderTitle("INFOS")
        showBack()

    }
}