package fr.epsi.projetandroidcours

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    fun setHeaderTitle(text:String){
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text=text
    }
}