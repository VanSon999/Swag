package vanson.dev.swag.Control

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import vanson.dev.swag.R
import vanson.dev.swag.Utilities.EXTRA_CATEGORY

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)
    }
}