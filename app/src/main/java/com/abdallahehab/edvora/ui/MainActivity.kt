package com.abdallahehab.edvora.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdallahehab.edvora.R
import com.abdallahehab.edvora.data.User
import com.abdallahehab.edvora.databinding.ActivityMainBinding
import com.abdallahehab.edvora.ridesList


class MainActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener{

    private lateinit var filterDialog: Dialog
    private lateinit var txtFilter: TextView
    private lateinit var binding: ActivityMainBinding
    private lateinit var user: User

    var country = arrayOf("India", "USA", "China", "Japan", "Other")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()

        constructFilterDialog()

        setListenerForFilterText()

        constructRecyclerView()

        setSpinnersAdapters()

        binding.txtUserName.text = user.name

    }


    private fun initialize() {
        txtFilter = binding.txtFilter
        user = User(40,"Dhruv Singh","url")
    }

    private fun constructFilterDialog() {
        filterDialog = Dialog(this)
        filterDialog.setContentView(R.layout.custom_popup_filter_menu)
        filterDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        setDialogPosition()

    }

    private fun setDialogPosition() {
        val window = filterDialog.window
        val layoutParameter = window?.attributes
        layoutParameter?.gravity = Gravity.TOP or Gravity.END
        layoutParameter?.horizontalMargin = .05f
        layoutParameter?.verticalMargin = .16f
        window?.attributes = layoutParameter
    }

    private fun setListenerForFilterText() {
        txtFilter.setOnClickListener {
            filterDialog.show()
        }
    }

    private fun constructRecyclerView(){
        val adapter= RideAdapter(ridesList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(
            baseContext,
            RecyclerView.VERTICAL,
            false)
    }

    private fun setSpinnersAdapters(){
        val spin = findViewById<View>(R.id.spinner) as Spinner?
        spin?.setOnItemSelectedListener(this)

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spin?.adapter = aa
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}