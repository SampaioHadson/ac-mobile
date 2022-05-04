package com.example.brcommobileimovelparatodos.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.brcommobileimovelparatodos.R
import com.example.brcommobileimovelparatodos.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var itens = arrayOf("Do this", "Or this", "Or This", "Abc do B",
            "Do this", "Or this", "Or This", "Abc do B",
            "Do this", "Or this", "Or This", "Abc do B",
            "Do this", "Or this", "Or This", "Abc do B",
            "Do this", "Or this", "Or This", "Abc do B");
        var view = inflater?.inflate(R.layout.activity_home, null);

        var listView = view.findViewById<ListView>(R.id.mainMenuList);

        var listViewAdapter =  ArrayAdapter<String>(view.context, android.R.layout.simple_list_item_1, itens);

        listView.adapter = listViewAdapter;

        return view;
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}