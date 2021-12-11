package fr.epsi.projetandroidcours

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    fun setHeaderTitle(text:String){
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text=text
    }

    fun showBack(){
        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility= View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }
}