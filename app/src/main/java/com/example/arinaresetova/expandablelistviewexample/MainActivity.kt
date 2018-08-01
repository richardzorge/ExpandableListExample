package com.example.arinaresetova.expandablelistviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.ListAdapter

class MainActivity : AppCompatActivity() {
    var listAdapter:ExpandableListViewItemAdapter?=null
    var listView: ExpandableListView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = this.findViewById<ExpandableListView>(R.id.expanded_list_view)
        var headers:ArrayList<String> = getHeaders()
        var items:HashMap<String, ArrayList<ListItem>> = getItems()
        listAdapter = ExpandableListViewItemAdapter(this,headers, items)
        listView!!.adapter = listAdapter as ListAdapter
    }

    fun getHeaders():ArrayList<String>
    {
        var result:ArrayList<String> = ArrayList()
        result.add("Group 1")
        result.add("Group 2")
        return result
    }

    fun getItems():HashMap<String, ArrayList<ListItem>>
    {
        var result:HashMap<String, ArrayList<ListItem>> = HashMap<String, ArrayList<ListItem>>()
        var array1:ArrayList<ListItem> = ArrayList<ListItem>()
        array1.add(ListItem(0,"Item 11"))
        array1.add(ListItem(1,"Item 12"))
        array1.add(ListItem(2,"Item 13"))

        result.put("Group 1",array1)

        var array2:ArrayList<ListItem> = ArrayList<ListItem>()
        array2.add(ListItem(0,"Item 21"))
        array2.add(ListItem(1,"Item 22"))
        array2.add(ListItem(2,"Item 23"))
        return result
    }
}
