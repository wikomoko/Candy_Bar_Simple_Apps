package com.example.candybar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheet :BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflater=inflater.inflate(R.layout.bottom_sheet_menu,container,false)
        val btn_order:Button=inflater.findViewById(R.id.btn_order)
        btn_order.setOnClickListener {
            val intent=Intent(context,successPage::class.java)
            startActivity(intent)
        }
        return inflater
    }
}