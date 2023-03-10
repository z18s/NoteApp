package com.example.noteapp.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noteapp.mvvm.model.data.NotesRepository
import com.example.noteapp.mvvm.model.data.entity.Note

class MainViewModel : ViewModel() {

    private var notesLiveData = MutableLiveData<List<Note>>()

    init {
        NotesRepository.getNotes().observeForever {
            notesLiveData.value = it
        }
    }

    fun getNotesLiveData(): LiveData<List<Note>> = notesLiveData
}