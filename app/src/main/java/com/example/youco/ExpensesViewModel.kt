package com.example.sample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpensesViewModel(application: Application):AndroidViewModel(application) {

    val allExpenses:LiveData<List<Expenses>>
    val repository:ExpensesRepository
    init {
        val dao =ExpensesDatabase.getDatabase(application).getExpensesDao()
        repository=ExpensesRepository(dao)
        allExpenses=repository.allExpenses
    }

    fun deleteExpense(expenses: Expenses)=viewModelScope.launch(Dispatchers.IO) {
    repository.delete(expenses)
    }

    fun insertExpense(expenses: Expenses)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(expenses)
    }
}
