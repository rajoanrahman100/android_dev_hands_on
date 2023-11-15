package com.example.myapplication.recyclerView_project

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recyclerView_project.dataClass.People

class MainActivityRecyclerView : AppCompatActivity() {
    private lateinit var myRecyclerView: RecyclerView
    var listOfItem = listOf<People>(
        People(name = "Bristy", role = "Mother"),
        People(name = "Rifat", role = "Father"),
        People(name = "Ihan", role = "Son"),
        People(name = "Arisha", role = "Daughter"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recycler_view)
        myRecyclerView = findViewById(R.id.myRecyclerView)

        //set bg color for recycler view
        myRecyclerView.setBackgroundColor(resources.getColor(R.color.card_background))

        //set layout manager
        myRecyclerView.layoutManager = LinearLayoutManager(this)

        //set adapter class
        myRecyclerView.adapter = MyRecyclerViewAdapter(listOfItem) { selectedItem: People ->
            listItemClicked(
                selectedItem
            )
        }
    }

    fun listItemClicked(people: People) {
        Toast.makeText(this@MainActivityRecyclerView, "Click on ${people.name}", Toast.LENGTH_SHORT)
            .show()
    }
}