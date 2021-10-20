package com.example.sample

import androidx.lifecycle.LiveData

class ExpensesRepository(private val expensesDao:ExpensesDao) {

        val allExpenses: LiveData<List<Expenses>> = expensesDao.getallexpenses()

     suspend fun insert(expense: Expenses) {
            expensesDao.insert(expense)
        }

       suspend fun delete(expense: Expenses) {
           expensesDao.delete(expense)
       }
    }
