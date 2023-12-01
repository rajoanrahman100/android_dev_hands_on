package com.example.myapplication.roomDB_crud_project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.roomDB_crud_project.adaptarClass.StudentRecyclerViewAdapter
import com.example.myapplication.roomDB_crud_project.db.Student
import com.example.myapplication.roomDB_crud_project.db.StudentDatabase
import com.example.myapplication.roomDB_crud_project.viewModel.StudentViewModel
import com.example.myapplication.roomDB_crud_project.viewModel.StudentViewModelFactory

class RoomDBMainActivity : AppCompatActivity() {

    private lateinit var etStudentName: EditText
    private lateinit var etStudentEmail: EditText
    private lateinit var saveButton: Button
    private lateinit var clearButton: Button
    private lateinit var studentRecyclerView: RecyclerView
    private lateinit var studentRecyclerViewAdapter: StudentRecyclerViewAdapter
    private lateinit var viewModel: StudentViewModel

    private lateinit var selectedStudent: Student
    private var isListItemClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_dbmain)

        etStudentName = findViewById(R.id.editStudentName)
        etStudentEmail = findViewById(R.id.editStudentEmail)
        saveButton = findViewById(R.id.btnSave)
        clearButton = findViewById(R.id.btnClear)
        studentRecyclerView = findViewById(R.id.rvStudent)

        val dao = StudentDatabase.getInstance(applicationContext).studentDao()
        val factory = StudentViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory)[StudentViewModel::class.java]

        saveButton.setOnClickListener {

            if (isListItemClicked) {
                updateStudentData()
                clearStudentData()
            } else {
                saveStudentData()
                clearStudentData()
            }


        }

        clearButton.setOnClickListener {

            if (isListItemClicked) {
                deleteStudentData()
                clearStudentData()
            } else {
                clearStudentData()
            }


        }

        initRecyclerAdapter()

    }

    private fun saveStudentData() {
        val name = etStudentName.text.toString()
        val email = etStudentEmail.text.toString()

        val student = Student(0, name, email)
        viewModel.insertStudent(student)

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
        val name = etStudentName.text.toString()
        val email = etStudentEmail.text.toString()

        val student = Student(selectedStudent.id, name, email)
        viewModel.updateStudent(student)

        saveButton.text = "Save"
        clearButton.text = "Clear"
        isListItemClicked = false
    }

    private fun deleteStudentData() {
        val name = etStudentName.text.toString()
        val email = etStudentEmail.text.toString()

        val student = Student(selectedStudent.id, name, email)
        viewModel.deleteStudent(student)

        saveButton.text = "Save"
        clearButton.text = "Clear"
        isListItemClicked = false
    }

    private fun clearStudentData() {
        etStudentName.setText("")
        etStudentEmail.setText("")
    }

    private fun initRecyclerAdapter() {
        studentRecyclerView.layoutManager = LinearLayoutManager(this)
        studentRecyclerViewAdapter = StudentRecyclerViewAdapter { selectStudent: Student ->
            listItemClicked(selectStudent)
        }
        studentRecyclerView.adapter = studentRecyclerViewAdapter

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
        selectedStudent = student
        saveButton.text = "Update"
        clearButton.text = "Delete"
        isListItemClicked = true
        etStudentName.setText(selectedStudent.name)
        etStudentEmail.setText(selectedStudent.email)

    }
}