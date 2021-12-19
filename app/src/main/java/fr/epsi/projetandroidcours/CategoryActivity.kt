package fr.epsi.projetandroidcours

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CategoryActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        setHeaderTitle("RAYONS")
        showBack()

        val categories = arrayListOf<Category>()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val categoryAdapter = CategoryAdapter(categories)
        recyclerView.adapter=categoryAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url("https://djemam.com/epsi/categories.json")
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if(data!=null){
                    val jsCategories = JSONObject(data)
                    val jsArrayCategories= jsCategories.getJSONArray("items")
                    for(i in 0 until jsArrayCategories.length()){
                        val jsCategory = jsArrayCategories.getJSONObject(i)
                        val category = Category(jsCategory.optString("category_id",""),
                            jsCategory.optString("title",""),
                            jsCategory.optString("products_url",""))
                        categories.add(category)
                        Log.d("category",category.title)
                    }
                    Log.d("Category","${categories.size}")
                    runOnUiThread(Runnable {
                        categoryAdapter.notifyDataSetChanged()
                    })
                }
            }

        })
    }
}