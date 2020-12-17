package vanson.dev.swag.Control

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_product.*
import vanson.dev.swag.Adapters.ProductsAdapter
import vanson.dev.swag.R
import vanson.dev.swag.Services.DataService
import vanson.dev.swag.Utilities.EXTRA_CATEGORY

class ProductActivity : AppCompatActivity() {
    lateinit var adapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType!!))

        productListView.layoutManager = GridLayoutManager(this, 2)
        productListView.adapter = adapter
    }
}