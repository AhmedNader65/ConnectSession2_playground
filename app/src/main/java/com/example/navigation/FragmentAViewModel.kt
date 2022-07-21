package com.example.navigation

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentABinding
import com.example.navigation.model.User


class FragmentViewModel : ViewModel() {

 fun saveUser(user : User){

 }
}

class FragmentBViewModel() : ViewModel() {
 val data = MutableLiveData<String>("")
}