package com.example.sample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Expenses_table")
class Expenses(@ColumnInfo(name = "text") val description:String,@ColumnInfo(name = "amount") val amount:String
               ) {
    @PrimaryKey(autoGenerate = true) var id=0


}