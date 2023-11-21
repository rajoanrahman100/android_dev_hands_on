package com.example.myapplication.roomDB_crud_project.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.roomDB_crud_project.db.StudentDao

class StudentViewModelFactory(
    private val dao: StudentDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            return StudentViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}