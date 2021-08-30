package com.r19.tabbedapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast

class ChatsFragment : Fragment() {

    //initializing myChats variable
    var myChats:ListView? = null

    companion object {
        fun newInstance() = ChatsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root:View = inflater.inflate(R.layout.chats_fragment, container, false)
        myChats = root.findViewById(R.id.listView)
        myChats!!.setOnItemClickListener { adapterView, view, i, l ->
            var name = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(context, name+" clicked", Toast.LENGTH_LONG)
        }
        return root
    }

}