package com.example.youco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sample.Expenses
import com.example.sample.ExpensesRVAdapter
import com.example.sample.ExpensesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ExpensesRVAdapter.IExpensesRVAdapter {
    lateinit var viewModel: ExpensesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerview.layoutManager= LinearLayoutManager(this)
        val adapter= ExpensesRVAdapter(this,this)
        recyclerview.adapter=adapter

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            ExpensesViewModel::class.java)
        viewModel.allExpenses.observe(this, Observer {list->
            list?.let{
                adapter.updateList(it)
            }

        })



    }

    override fun onItemClicked(expenses: Expenses) {
        viewModel.deleteExpense(expenses)
        Toast.makeText(this,"${expenses.description} Deleted", Toast.LENGTH_LONG).show()
    }

    fun SubmitData(view: View) {
        val expenseText=input.text.toString()
        val amountText=inputamt.text.toString()
        if(expenseText.isNotEmpty()){
            viewModel.insertExpense(Expenses(expenseText,amountText) )
            Toast.makeText(this,"Item Inserted", Toast.LENGTH_LONG).show()
        }
    }
}

