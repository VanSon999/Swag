package vanson.dev.swag.Control

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import vanson.dev.swag.Adapters.CategoryRecycleAdapter
import vanson.dev.swag.R
import vanson.dev.swag.Services.DataService
import vanson.dev.swag.Utilities.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {

////    lateinit var adapter : ArrayAdapter<Category>
//    lateinit var adapter : CategoryAdapter
    lateinit var adapter: CategoryRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        adapter = CategoryRecycleAdapter(this, DataService.categories)
        adapter = CategoryRecycleAdapter(this,DataService.categories){
            val productIntent = Intent(this, ProductActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, it.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        //Use to manage position items
        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
////        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataService.categories)
//        adapter = CategoryAdapter(this,DataService.categories)
//        categoryListView.adapter = adapter
//
////        Don't work with recycle view
////        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
////            val category = DataService.categories[i]
////            Toast.makeText(this, "You cliked on the ${category.title} cell",Toast.LENGTH_LONG).show()
////        }
    }
}