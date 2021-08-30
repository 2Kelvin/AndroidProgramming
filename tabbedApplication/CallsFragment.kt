package com.r19.tabbedapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CallsFragment : Fragment() {

    companion object {
        fun newInstance() = CallsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root:View = inflater.inflate(R.layout.calls_fragment, container, false)
        return root
    }


}