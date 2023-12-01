package com.example.myapplication.roomDB_crud_project.adaptarClass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.roomDB_crud_project.db.Student

class StudentRecyclerViewAdapter(private val clickListener:(Student)->Unit) : RecyclerView.Adapter<StudentViewHolder>() {

    private var listOfStudent = ArrayList<Student>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.student_db_list_item, parent, false)
        return StudentViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return listOfStudent.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        holder.bind(listOfStudent[position],clickListener)
    }


    fun setList(student: List<Student>) {
        listOfStudent.clear()
        listOfStudent.addAll(student)
    }

}

class StudentViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(student: Student,clickListener:(Student)->Unit) {
        val nameTextView = view.findViewById<TextView>(R.id.studentTvName)
        val emailTextView = view.findViewById<TextView>(R.id.studentTvEmail)
        nameTextView.text = student.name
        emailTextView.text = student.email
        view.setOnClickListener {
            clickListener(student)
        }
    }

    /*
    * clickListener: is a function name
    * (Student): lambda expression
    * Unit: No return type
    * */
}