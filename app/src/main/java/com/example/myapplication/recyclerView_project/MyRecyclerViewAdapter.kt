package com.example.myapplication.recyclerView_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recyclerView_project.dataClass.People

class MyRecyclerViewAdapter(
    private var listOfItem: List<People>,
    private var clickListener: (People) -> Unit
) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        //define the size of list
        return listOfItem.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, index: Int) {
        //display data
        holder.bind(listOfItem[index], clickListener)

    }

}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(people: People, clickListener: (People) -> Unit) {
        val nameTV = view.findViewById<TextView>(R.id.itemTv)
        val roleTV = view.findViewById<TextView>(R.id.roleTv)
        nameTV.text = "Name: ${people.name}"
        roleTV.text = "Role: ${people.role}"

        //Way One
//        view.setOnClickListener {
//            Toast.makeText(view.context, "Click on ${people.name}", Toast.LENGTH_SHORT).show()
//        }
        view.setOnClickListener { clickListener(people) }
    }
}