package com.example.arinaresetova.expandablelistviewexample

import android.graphics.Typeface
import android.widget.ArrayAdapter
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import java.util.zip.Inflater

class ExpandableListViewItemAdapter(
        private val context: AppCompatActivity,
        private val groups:ArrayList<String>,
        private val child_items:HashMap<String,ArrayList<ListItem>>
): BaseExpandableListAdapter()
{
    override fun getGroup(position: Int): Any {
        return groups.get(position)
    }

    override fun isChildSelectable(group_position: Int, child_position: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(group_position: Int, is_expanded: Boolean, convert_view: View?, parent: ViewGroup?): View {
        var header_title:String = getGroup(group_position) as String
        var view:View? = convert_view
        if(view==null)
        {
            view = context.layoutInflater.inflate(R.layout.template_list_view_group, null)
        }
        var text_view:TextView = view!!.findViewById<TextView>(R.id.list_group_header_text)
        text_view.setTypeface(null, Typeface.BOLD)
        text_view.setText(header_title)
        return view
    }

    override fun getChildrenCount(position: Int): Int {
        return child_items.size
    }

    override fun getChild(group_position: Int, children_position: Int): Any {
        return child_items.get(groups.get(group_position))!!.get(children_position)
    }

    override fun getGroupId(group_position: Int): Long {
        return group_position as Long
    }

    override fun getChildView(group_position: Int, child_position: Int, is_last_child: Boolean, convert_view: View?, parent: ViewGroup?): View {
        var text:String = getChild(group_position, child_position) as String
        var view:View? = convert_view
        if(view==null)
        {
            view = context.layoutInflater.inflate(R.layout.template_list_child_item, null)
        }
        var text_view:TextView = view!!.findViewById<TextView>(R.id.list_child_item_text)
        text_view.setText(text)
        return view
    }

    override fun getChildId(group_position: Int, child_position: Int): Long {
        return child_position as Long
    }

    override fun getGroupCount(): Int {
        return groups.size
    }

}