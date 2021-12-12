package fr.epsi.projetandroidcours

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class StudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        setHeaderTitle("PROFIL")
        showBack()

        val nameProfile = findViewById<TextView>(R.id.text_Student_name)
        nameProfile.text = intent.getStringExtra("nameStudent")
        val emailProfile = findViewById<TextView>(R.id.text_Student_email)
        emailProfile.text = intent.getStringExtra("emailStudent")


    }
}