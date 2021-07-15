package com.example.candybar

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.candybar.databinding.ActivityOrderPageBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class orderPage : AppCompatActivity() {
    private lateinit var binding:ActivityOrderPageBinding
    companion object{
        val input_candy_name="candy name"
        val input_candy_image="0"
        val input_candy_price="5000"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_order_page)



        val candy_name=intent.getStringExtra(input_candy_name)
        val candy_image=intent.getIntExtra(input_candy_image,0)
        val candy_price=intent.getIntExtra(input_candy_price,0)
        binding.candyTitle.text=candy_name.toString()
        binding.imgCandy.setImageResource(candy_image.toInt())
        binding.candyPrice.text="Rp $candy_price"
        supportActionBar?.title="Ordering ${candy_name.toString()}"

        binding.shareBtn.setOnClickListener { goShare(candy_name.toString(),candy_price.toString()) }

        binding.buyBtn.setOnClickListener { goOrder()}

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun goOrder() {
        val bottomSheet=BottomSheet()
        bottomSheet.show(supportFragmentManager,"Bottom Sheet")

    }

    private fun goShare(name:String,price:String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Hi, I've bought $name only for Rp.$price")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_home -> {
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            R.id.menu_order->{
                goOrder()
                true
            }
            R.id.menu_share->{
                goShare(input_candy_name, input_candy_price)
                true
            }
            R.id.menu_exit->{
               val alert=AlertDialog.Builder(this).setTitle("Exitting App")
                       .setIcon(R.drawable.ic_exit)
                       .setMessage("Are You Sure to Exit this App ?")
                       .setPositiveButton("Exit",DialogInterface.OnClickListener { dialog, which -> finishAffinity() })
                       .setNegativeButton("Cancel",DialogInterface.OnClickListener { dialog, which ->
                           Toast.makeText(this,"cancel from exiting app",Toast.LENGTH_SHORT).show()
                       })
                alert.show()
                true
            }

            android.R.id.home->{
                finish()
                true
            }
            else ->super.onOptionsItemSelected(item)
        }
    }
}