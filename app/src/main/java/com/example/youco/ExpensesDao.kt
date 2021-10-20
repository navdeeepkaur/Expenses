package com.example.sample

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ExpensesDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(expenses: Expenses)

    @Delete
    suspend fun delete(expenses: Expenses)

    @Query("Select * from expenses_table order by id ASC")
    fun getallexpenses(): LiveData<List<Expenses>>

}