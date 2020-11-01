package com.mn9.mnotes3.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mn9.mnotes3.db.DatabaseHelper
import com.mn9.mnotes3.utils.Resource
import kotlinx.coroutines.launch
import java.lang.Exception

class MainFragmentViewModel(private val dbHelper: DatabaseHelper) : ViewModel() {

    private val notes = MutableLiveData<Resource<List<Note>>>()

    init {
        fetchNotes()
    }

    private fun fetchNotes() {
        viewModelScope.launch {
            notes.postValue(Resource.loading(null))
            try {
                var notesFromDb = dbHelper.getAllNotes()
            } catch (e: Exception) {
                notes.postValue(Resource.error("Something Went Wrong", null))
            }
        }
    }

    fun getNotes(): LiveData<Resource<List<Note>>> {
        return notes
    }
}