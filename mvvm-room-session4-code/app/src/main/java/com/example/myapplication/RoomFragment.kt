package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentRoomBinding
import com.example.myapplication.roomcode.NoteViewModel
import com.example.myapplication.roomcode.database.NoteDatabase
import com.example.myapplication.roomcode.NoteViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [RoomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RoomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRoomBinding>(inflater, R.layout.fragment_room, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = NoteDatabase.getInstance(application).noteDao
        val noteViewModelFactory =
            NoteViewModelFactory(dataSource)
        val noteViewModel = ViewModelProvider(this, noteViewModelFactory).get(NoteViewModel::class.java)
        binding.lifecycleOwner = this
        binding.noteViewModel = noteViewModel

        // Inflate the layout for this fragment
        return binding.root
    }

}