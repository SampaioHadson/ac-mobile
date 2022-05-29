package com.example.brcommobileimovelparatodos.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.brcommobileimovelparatodos.Home
import com.example.brcommobileimovelparatodos.ItemDetailsActivity
import com.example.brcommobileimovelparatodos.R
import com.example.brcommobileimovelparatodos.databinding.FragmentHomeBinding

class MeusImoveisFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view = inflater?.inflate(R.layout.activity_home, null);
        var listView = view.findViewById<ListView>(R.id.mainMenuList);

        var arrayListItems = setDataArrayList()

        listView.setOnItemClickListener { adapterView, view, i, l ->
            var intent = Intent(view.context, ItemDetailsActivity::class.java)
            intent.putExtra("icons", arrayListItems[i].icons)
            intent.putExtra("title", arrayListItems[i].title)
            intent.putExtra("details", arrayListItems[i].details)
            startActivity(intent)
        }
        var itemsListAdpater = MeusItemsListAdpter(view.context, arrayListItems)

        listView.adapter = itemsListAdpater;

        return view;
    }

    private fun setDataArrayList() : ArrayList<ItemList>{
        var arrayList = ArrayList<ItemList>()

        arrayList.add(ItemList(R.drawable.casa1, "AA", "CAS"))


        return arrayList!!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}