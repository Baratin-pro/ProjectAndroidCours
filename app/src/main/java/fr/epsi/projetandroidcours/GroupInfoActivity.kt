package fr.epsi.projetandroidcours

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class GroupInfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_info)
        setHeaderTitle("INFOS")
        showBack()

        val buttonStudentOne = findViewById<Button>(R.id.button_GroupInfo_studentOne)

        buttonStudentOne.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentActivity::class.java)
            newIntent.putExtra("nameStudent","Enzo")
            newIntent.putExtra("emailStudent","enzo@gmail.com")
            startActivity(newIntent)
        })

        val buttonStudentTwo = findViewById<Button>(R.id.button_GroupInfo_studentTwo)

        buttonStudentTwo.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentActivity::class.java)
            newIntent.putExtra("nameStudent","Andrew")
            newIntent.putExtra("emailStudent","andrew@gmail.com")
            startActivity(newIntent)
        })
    }
}