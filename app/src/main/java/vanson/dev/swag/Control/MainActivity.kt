package vanson.dev.swag.Control

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import vanson.dev.swag.Adapters.CategoryAdapter
import vanson.dev.swag.Model.Category
import vanson.dev.swag.R
import vanson.dev.swag.Services.DataService

class MainActivity : AppCompatActivity() {

//    lateinit var adapter : ArrayAdapter<Category>
    lateinit var adapter : CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataService.categories)
        adapter = CategoryAdapter(this,DataService.categories)
        categoryListView.adapter = adapter

//        Don't work with recycle view
//        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
//            val category = DataService.categories[i]
//            Toast.makeText(this, "You cliked on the ${category.title} cell",Toast.LENGTH_LONG).show()
//        }
    }
}