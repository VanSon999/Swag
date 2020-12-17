package vanson.dev.swag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.category_list_item.view.*
import vanson.dev.swag.Model.Category
import vanson.dev.swag.R

class CategoryRecycleAdapter(val context: Context, val categories: List<Category>, val itemClick: (Category) -> Unit): RecyclerView.Adapter<CategoryRecycleAdapter.Holder>(){
    inner class Holder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context){
//            println("Recycle")
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
//            categoryName.setOnClickListener{itemClick(category)}
            //ItemView here is default attribute of Holder not thing from constructor
            itemView.setOnClickListener { itemClick(category) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.category_list_item, parent,false)
//        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent,false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(p0: Holder, position: Int) {
        p0?.bindCategory(categories[position], context)
    }
}