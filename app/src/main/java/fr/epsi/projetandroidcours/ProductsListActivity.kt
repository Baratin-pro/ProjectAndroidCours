package fr.epsi.projetandroidcours

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductsListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)
        setHeaderTitle("BOISSONS")
        showBack()
        val products = arrayListOf<ProductsList>()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val productAdapter = ProductsListAdapter(products)
        recyclerView.adapter=productAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url("https://djemam.com/epsi/boissons.json")
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
                    val jsProducts = JSONObject(data)
                    val jsArrayProducts= jsProducts.getJSONArray("items")
                    for(i in 0 until jsArrayProducts.length()){
                        val jsProduct = jsArrayProducts.getJSONObject(i)
                        val product = ProductsList(jsProduct.optString("name",""),
                            jsProduct.optString("description",""),
                            jsProduct.optString("picture_url",""))
                        products.add(product)
                        Log.d("product",product.name)
                    }
                    Log.d("Product","${products.size}")
                    runOnUiThread(Runnable {
                        productAdapter.notifyDataSetChanged()
                    })
                }
            }

        })
    }
}