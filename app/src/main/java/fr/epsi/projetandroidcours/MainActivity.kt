package fr.epsi.projetandroidcours

import android.content.Intent
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGroupInfo = findViewById<Button>(R.id.button_home_group_info)
        buttonGroupInfo.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, GroupInfoActivity::class.java)
            startActivity(newIntent)
        })

        val buttonCategory = findViewById<Button>(R.id.button_home_categories)
        buttonCategory.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,CategoryActivity::class.java)
            startActivity(newIntent)
        })

        setHeaderTitle("EPSI")
    }
}