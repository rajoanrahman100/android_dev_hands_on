package com.example.myapplication.roomDB_crud_project.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.roomDB_crud_project.db.Student
import com.example.myapplication.roomDB_crud_project.db.StudentDao
import kotlinx.coroutines.launch

class StudentViewModel(private val dao: StudentDao) : ViewModel() {

    val student = dao.getAllStudents()

    fun insertStudent(student: Student) {
        viewModelScope.launch {
            dao.insertStudent(student)
        }
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch {
            dao.deleteStudent(student)
        }
    }

    fun updateStudent(student: Student) {
        viewModelScope.launch {
            dao.updateStudent(student)
        }
    }


}