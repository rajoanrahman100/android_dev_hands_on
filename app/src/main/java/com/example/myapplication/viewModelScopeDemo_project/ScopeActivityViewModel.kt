package com.example.myapplication.viewModelScopeDemo_project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.viewModelScopeDemo_project.model.User
import com.example.myapplication.viewModelScopeDemo_project.model.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScopeActivityViewModel : ViewModel() {

    //private val myJob= Job()
    //private val myScope= CoroutineScope(Dispatchers.IO+myJob) //Initialize coroutine

    private var userRepository = UserRepository()
    var users: MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData() {
        viewModelScope.launch {
            val result: List<User>
            withContext(Dispatchers.IO) {
                result = userRepository.getUser()
            }
            users.value = result
        }
    }

//    override fun onCleared() {
//        super.onCleared()
//        myJob.cancel()
//    }
}

/*
* ViewModelScope is a CoroutineScope tied to a ViewModel.
* ViewModel scope automatically handle onClear() method when viewModel lifecycle is destroyed
* */