package vanson.dev.swag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import vanson.dev.swag.Model.Category
import vanson.dev.swag.R
//import java.text.FieldPosition

class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter() {
    val context = context
    val categories = categories
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val categoryView: View = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
//        val categoryImage: ImageView = categoryView.findViewById(R.id.categoryImage)
//        val categoryName: TextView = categoryView.findViewById(R.id.categoryName)
//        println("Heavy Search")
//
//        val category = categories[position]
//
//        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
//        categoryImage.setImageResource(resourceId)
//        categoryName.text = category.title
//        return categoryView
        val categoryView: View
        val holder: ViewHolder
        if(convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            categoryView.tag = holder
        }else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }
        val category = categories[position]
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.title
        return categoryView
    }

    override fun getItem(p0: Int): Any {
        return categories[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }
//    Use ViewHolder pattern to decrease Heavy Search
    private class ViewHolder{
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }
}