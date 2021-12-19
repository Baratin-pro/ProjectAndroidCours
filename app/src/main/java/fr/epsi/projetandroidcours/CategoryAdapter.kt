package fr.epsi.projetandroidcours

import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.projetandroidcours.CategoryAdapter.ViewHolder

class CategoryAdapter(private val categories: ArrayList<Category>): RecyclerView.Adapter<ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val buttonViewTitle: Button = view.findViewById (R.id.button_categories_rayon)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_category, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.buttonViewTitle.text = category.title
        holder.buttonViewTitle.id = Integer.parseInt(category.category_id)
        if (category.category_id == "1"){
            holder.buttonViewTitle.setOnClickListener {
                    v->
                Log.d(TAG,"onItemClick :" + holder.buttonViewTitle)
                val intent = Intent(v.context, ProductsListActivity::class.java)
                v.context.startActivity(intent)
            }
        }



    }

    override fun getItemCount(): Int {
        return categories.size
    }

}