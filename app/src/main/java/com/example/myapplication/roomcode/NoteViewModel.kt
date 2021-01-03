package com.example.myapplication.roomcode

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.roomcode.database.Note
import com.example.myapplication.roomcode.database.NoteDao
import kotlinx.coroutines.launch

class NoteViewModel(private val database: NoteDao): ViewModel() {

    val notes: LiveData<List<Note>> = database.getAllNotes()

    init {
        val n: List<Note>? = notes.value
        Log.i("NoteViewModel", "${n?.toString()}")
    }

    fun onAdd() {
        viewModelScope.launch {
            val newNote = Note(title = "Angular", body = "Vue")
            insert(newNote)
            val n: List<Note>? = notes.value
            Log.i("NoteViewModel", "${n?.toString()}")
        }
    }

    private suspend fun insert(newNote: Note) {
        database.insert(newNote)
    }

    fun onClear(){
        viewModelScope.launch {
            clearAllData()
        }
    }

    private suspend fun clearAllData() {
        database.clear()
        Log.i("Cleared", "Cleared everything")
    }


}