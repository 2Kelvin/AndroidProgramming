package com.r19.ecommerceapplication

//copy code from line 3 - 52  -> link bit.ly/3yfLkRG
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var context: Context, var data:ArrayList<product>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var productName:TextView
        var productDescription:TextView
        var productPrice:TextView
        var productImage:ImageView
        init {
            this.productName = row?.findViewById(R.id.productName) as TextView
            this.productDescription = row?.findViewById(R.id.productDescription) as TextView
            this.productPrice = row?.findViewById(R.id.productPrice) as TextView
            this.productImage = row?.findViewById(R.id.productImage) as ImageView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.item_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:product = getItem(position) as product
        viewHolder.productName.text = item.name
        viewHolder.productDescription.text = item.description
        viewHolder.productPrice.text = item.price
        viewHolder.productImage.setImageResource(item.photo)
        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}