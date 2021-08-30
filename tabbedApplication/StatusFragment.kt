package com.r19.tabbedapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class StatusFragment : Fragment() {

    companion object {
        fun newInstance() = StatusFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root:View = inflater.inflate(R.layout.status_fragment, container, false)
        return root
    }

}