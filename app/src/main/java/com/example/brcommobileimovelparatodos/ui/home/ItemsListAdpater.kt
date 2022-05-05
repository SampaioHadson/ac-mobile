package com.example.brcommobileimovelparatodos.ui.home

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.brcommobileimovelparatodos.R

class ItemsListAdpater(var context: Context, var arrayList: ArrayList<ItemList>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return arrayList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = View.inflate(context, R.layout.activity_listitem, null)

        var imageView = view.findViewById<ImageView>(R.id.list_item_image)
        var titleText = view.findViewById<TextView>(R.id.list_item_title)
        var contentText = view.findViewById<TextView>(R.id.list_item_title)

        var itemList = arrayList.get(p0)

         imageView.setImageResource(itemList.icons!!)
         titleText.text = itemList.title
         contentText.text = itemList.details

        return view!!
    }
}