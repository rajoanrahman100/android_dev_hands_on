package com.example.myapplication.roomDB_crud_project

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRoomDbmainBinding
import com.example.myapplication.roomDB_crud_project.adaptarClass.StudentRecyclerViewAdapter
import com.example.myapplication.roomDB_crud_project.db.Student
import com.example.myapplication.roomDB_crud_project.db.StudentDatabase
import com.example.myapplication.roomDB_crud_project.viewModel.StudentViewModel
import com.example.myapplication.roomDB_crud_project.viewModel.StudentViewModelFactory

class RoomDBMainActivity : AppCompatActivity() {

    private lateinit var studentRecyclerViewAdapter: StudentRecyclerViewAdapter
    private lateinit var viewModel: StudentViewModel

    private lateinit var selectedStudent: Student
    private var isListItemClicked = false
    private lateinit var binding: ActivityRoomDbmainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_room_dbmain)

        binding = ActivityRoomDbmainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val dao = StudentDatabase.getInstance(applicationContext).studentDao()
        val factory = StudentViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory)[StudentViewModel::class.java]

        binding.apply {
            btnSave.setOnClickListener {

                if (isListItemClicked) {
                    updateStudentData()
                    clearStudentData()
                } else {
                    saveStudentData()
                    clearStudentData()
                }


            }

            btnClear.setOnClickListener {

                if (isListItemClicked) {
                    deleteStudentData()
                    clearStudentData()
                } else {
                    clearStudentData()
                }


            }
        }



        initRecyclerAdapter()

    }

    private fun saveStudentData() {
        binding.apply {
            val name = editStudentName.text.toString()
            val email = editStudentEmail.text.toString()

            val student = Student(0, name, email)
            viewModel.insertStudent(student)
        }

        ///TODO: Another way to do insert operation
        /*viewModel.insertStudent(
            Student(
                0,
                etStudentName.text.toString(),
                etStudentEmail.text.toString()
            )
        )*/

    }

    private fun updateStudentData() {
        binding.apply {
            val name = editStudentName.text.toString()
            val email = editStudentEmail.text.toString()

            val student = Student(selectedStudent.id, name, email)
            viewModel.updateStudent(student)

            btnSave.text = "Save"
            btnClear.text = "Clear"
            isListItemClicked = false
        }
    }

    private fun deleteStudentData() {
        binding.apply {
            val name = editStudentName.text.toString()
            val email = editStudentEmail.text.toString()

            val student = Student(selectedStudent.id, name, email)
            viewModel.deleteStudent(student)

            btnSave.text = "Save"
            btnClear.text = "Clear"
            isListItemClicked = false
        }
    }

    private fun clearStudentData() {
        binding.apply {
            editStudentName.setText("")
            editStudentEmail.setText("")
        }
    }

    private fun initRecyclerAdapter() {
        binding.rvStudent.layoutManager = LinearLayoutManager(this)
        studentRecyclerViewAdapter = StudentRecyclerViewAdapter { selectStudent: Student ->
            listItemClicked(selectStudent)
        }
        binding.rvStudent.adapter = studentRecyclerViewAdapter

        displayStudentList()
    }

    private fun displayStudentList() {
        viewModel.student.observe(this) {
            studentRecyclerViewAdapter.setList(it)
            studentRecyclerViewAdapter.notifyDataSetChanged()
        }
    }

    private fun listItemClicked(student: Student) {
        Toast.makeText(this, "Student name is ${student.name}", Toast.LENGTH_SHORT).show()
        binding.apply {

            selectedStudent = student
            btnSave.text = "Update"
            btnClear.text = "Delete"
            isListItemClicked = true
            editStudentName.setText(selectedStudent.name)
            editStudentEmail.setText(selectedStudent.email)
        }

    }
}