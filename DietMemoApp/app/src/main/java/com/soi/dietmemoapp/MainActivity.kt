package com.soi.dietmemoapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.Calendar
import java.util.GregorianCalendar

class MainActivity : AppCompatActivity() {

    val dataModelList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        val listView = findViewById<ListView>(R.id.mainListView)
        val adapter = ListViewAdapter(dataModelList)

        listView.adapter = adapter

        myRef.child(Firebase.auth.currentUser!!.uid).addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataModelList.clear()
                for (dataModel in snapshot.children) {
                    dataModelList.add(dataModel.getValue(DataModel::class.java)!!)
                    Log.d("Data", dataModel.toString())
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })




        val writeButton = findViewById<ImageView>(R.id.writeButton)
        writeButton.setOnClickListener {

            // custom dialog
            val dialogView = LayoutInflater.from(this).inflate(R.layout.custeom_dialog, null)
            val builder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("운동 메모 다이얼로그")

            val alertDialog = builder.show()
            val selectDateButton = alertDialog.findViewById<Button>(R.id.selectDateButton)
            var dateText = ""
            selectDateButton?.setOnClickListener {

                val today = GregorianCalendar()
                val year: Int = today.get(Calendar.YEAR)
                val month: Int = today.get(Calendar.MONTH)
                val date: Int = today.get(Calendar.DATE)

                val dialog = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                        selectDateButton.setText("${year}, ${month+1}, ${dayOfMonth}")
                        dateText = "${year}, ${month+1}, ${dayOfMonth}"
                    }
                }, year, month, date)

                dialog.show()
            }

            val saveButton = alertDialog.findViewById<Button>(R.id.saveButton)
            saveButton?.setOnClickListener {

                val helthMemo = alertDialog.findViewById<EditText>(R.id.helthMemo)?.text.toString()
                val model = DataModel(dateText, helthMemo)

                val database = Firebase.database
                val myRef = database.getReference("myMemo").child(Firebase.auth.currentUser!!.uid)
                myRef.push().setValue(model)

                alertDialog.dismiss()
            }
        }
    }
}