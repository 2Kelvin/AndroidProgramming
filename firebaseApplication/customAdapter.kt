package com.r19.firebaseapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class CustomAdapter(var context: Context, var data:ArrayList<user>):BaseAdapter() {
    private class ViewHolder(row:View?){

        //initializing variables for the textViews and buttons
        var viewName:TextView
        var viewEmail:TextView
        var viewIDNo:TextView
        var btnDelete:Button
        var btnUpdate:Button

        init {
            //grabbing the textViews and buttons by id
            this.viewName = row?.findViewById(R.id.viewName) as TextView
            this.viewEmail = row?.findViewById(R.id.viewEmail) as TextView
            this.viewIDNo = row?.findViewById(R.id.viewIDNo) as TextView
            this.btnDelete = row?.findViewById(R.id.btnDelete) as Button
            this.btnUpdate = row?.findViewById(R.id.btnUpdate) as Button
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.user_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:user = getItem(position) as user
        viewHolder.viewName.text = item.name
        viewHolder.viewEmail.text = item.email
        viewHolder.viewIDNo.text = item.IDNo
        //setting event handlers for the buttons
        viewHolder.btnDelete.setOnClickListener {
            //fetching the user by id and deleting them from the database
            var reference = FirebaseDatabase.getInstance().getReference().child("users/${item.id}")
            reference.removeValue()
            //message displaying that the user has been deleted successfully from the database
            Toast.makeText(context, "User deleted successfully", Toast.LENGTH_LONG).show()
        }
        viewHolder.btnUpdate.setOnClickListener {
            //created a new activity -> empty activity -> named 'update' in the main folder
            //carrying data to the new 'update' activity created
            var goToUpdate = Intent(context, update::class.java)
            //carrying data on an intent
            goToUpdate.putExtra("x", item.name)
            goToUpdate.putExtra("y", item.email)
            goToUpdate.putExtra("z", item.IDNo)
            goToUpdate.putExtra("id", item.id)
            context.startActivity(goToUpdate)
            //create textViews(name, email, ID number) and button update in activity_update.xml for the data to be displayed on
        }
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