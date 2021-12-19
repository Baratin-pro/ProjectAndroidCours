package fr.epsi.projetandroidcours

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val title = intent.getStringExtra("nameProduct")
        setHeaderTitle(title.toString())
        showBack()

        val descriptionProduct : TextView = findViewById(R.id.text_ProductDetails_description)
        descriptionProduct.text = intent.getStringExtra("descriptionProduct")

        val imageProduct : ImageView = findViewById(R.id.image_ProductDetails_picture)
        Picasso.get().load(intent.getStringExtra("imageProduct")).into(imageProduct)

    }
}