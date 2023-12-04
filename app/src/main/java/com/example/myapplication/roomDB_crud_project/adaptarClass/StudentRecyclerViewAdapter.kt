package com.example.myapplication.roomDB_crud_project.adaptarClass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.StudentDbListItemBinding
import com.example.myapplication.roomDB_crud_project.db.Student

class StudentRecyclerViewAdapter(private val clickListener: (Student) -> Unit) :
    RecyclerView.Adapter<StudentViewHolder>() {

    private var listOfStudent = ArrayList<Student>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {


        val binding =
            StudentDbListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return StudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfStudent.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        holder.bind(listOfStudent[position], clickListener)
    }


    fun setList(student: List<Student>) {
        listOfStudent.clear()
        listOfStudent.addAll(student)
    }

}

class StudentViewHolder(private val binding: StudentDbListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(student: Student, clickListener: (Student) -> Unit) {

        binding.studentTvName.text = student.name
        binding.studentTvEmail.text = student.email
        binding.root.setOnClickListener {
            clickListener(student)
        }
    }

    /*
    * clickListener: is a function name
    * (Student): lambda expression
    * Unit: No return type
    * */
}