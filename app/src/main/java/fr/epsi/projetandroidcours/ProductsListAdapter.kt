package fr.epsi.projetandroidcours

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.epsi.projetandroidcours.ProductsListAdapter.ViewHolder

class ProductsListAdapter(private val products: ArrayList<ProductsList>): RecyclerView.Adapter<ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textViewName: TextView = view.findViewById (R.id.textViewName)
        val textViewDescription: TextView = view.findViewById(R.id.textViewDescription)
        val imageViewProduct: ImageView = view.findViewById(R.id.imageViewProducts)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_products_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        val lenghtLimit = 40
        holder.textViewName.text = product.name

        if(product.description.length >= lenghtLimit) {
            holder.textViewDescription.text = "${product.description.substring(0, lenghtLimit)} ..."
        }else {
            holder.textViewDescription.text = product.description
        }
        Picasso.get().load(product.picture_url).into(holder.imageViewProduct)
    }

    override fun getItemCount(): Int {
        return products.size
    }





}