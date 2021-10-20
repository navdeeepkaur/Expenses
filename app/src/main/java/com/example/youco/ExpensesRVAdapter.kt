package com.example.sample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youco.R

class ExpensesRVAdapter(private val Context: Context,private val listener: IExpensesRVAdapter): RecyclerView.Adapter<ExpensesRVAdapter.ExpenseViewHolder>() {

    val allExpenses=ArrayList<Expenses>()

    inner class ExpenseViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val TextView=itemView.findViewById<TextView>(R.id.textViewItem)
        val TextView1=itemView.findViewById<TextView>(R.id.textViewItem1)
        val deleteButton=itemView.findViewById<ImageView>(R.id.deletebtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view_holder= ExpenseViewHolder(LayoutInflater.from(Context).inflate(R.layout.item_expense,parent,false))
        view_holder.deleteButton.setOnClickListener{
        listener.onItemClicked(allExpenses[view_holder.adapterPosition])
        }
        return view_holder
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val currentexpense=allExpenses[position]
        holder.TextView.text=currentexpense.description
        holder.TextView1.text= currentexpense.amount
    }

    override fun getItemCount(): Int {
        return allExpenses.size
    }

    fun updateList(newList:List<Expenses>){
        allExpenses.clear()
        allExpenses.addAll(newList)

        notifyDataSetChanged()
    }

interface IExpensesRVAdapter{
    fun onItemClicked(expenses:Expenses)
}
}