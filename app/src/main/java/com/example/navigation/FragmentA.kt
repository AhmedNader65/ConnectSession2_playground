package com.example.navigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentABinding
import com.example.navigation.model.User


class FragmentA : Fragment() {

    lateinit var viewModel: FragmentViewModel
    val viewModel2 by viewModels<FragmentViewModel>({requireActivity()})
    lateinit var binding: FragmentABinding
    lateinit var user: User
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[FragmentViewModel::class.java]
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        user = User("Ahmed","Ali",2)
        binding.user= user
        user.firstName = "Khaled"
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.save.setOnClickListener {
            viewModel.saveUser(user)
            requireActivity().onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.my_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_share -> {
                shareText()
                Toast.makeText(requireActivity(), "Share", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
//
    fun shareText() {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND

    sendIntent.setData(Uri.parse("https://google.com"));
        startActivity(sendIntent)
    }
}