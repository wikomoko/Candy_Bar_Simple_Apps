package com.example.candybar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.candybar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    var candies_name:String="Lollipop"
     var candies_image:Int =R.drawable.lollipop
    var candies_price:Int=5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.lollipopBtn.setOnClickListener { doChanger(R.drawable.lollipop,"Lollipop",1,it) }
        binding.pepperBtn.setOnClickListener {doChanger(R.drawable.pepper,"Peppermint",2,it)  }
        binding.gumBtn.setOnClickListener { doChanger(R.drawable.gum,"Gum Candy",3,it)}
        binding.candyBtn.setOnClickListener {doChanger(R.drawable.candy,"Regular Candy",4,it) }
        binding.chocolateBtn.setOnClickListener { doChanger(R.drawable.chocolate,"Chocolate",5,it) }
        binding.jellyBtn.setOnClickListener { doChanger(R.drawable.jelly,"Jelly Beans",6,it) }

//        val bottomSheetFragment=BottomSheet()
//        binding.okBtn.setOnClickListener { bottomSheetFragment.show(supportFragmentManager,"Bottom Sheet") }

        binding.okBtn.setOnClickListener {
           val movedata=Intent(this,orderPage::class.java)
                                movedata.putExtra(orderPage.input_candy_name,candies_name)
                                movedata.putExtra(orderPage.input_candy_image,candies_image)
                                movedata.putExtra(orderPage.input_candy_price,candies_price)
            startActivity(movedata)
        }
    }

    private fun doChanger(item:Int,candyName:String,pivot:Int,view:View) {

        binding.okBtn.setImageResource(item)

        binding.candyNameText.text="$candyName"

        Toast.makeText(this,"You have selected $candyName",Toast.LENGTH_SHORT).show()

        binding.lollipopBtn.setImageResource(R.drawable.lollipop)
        binding.pepperBtn.setImageResource(R.drawable.pepper)
        binding.gumBtn.setImageResource(R.drawable.gum)
        binding.candyBtn.setImageResource(R.drawable.candy)
        binding.chocolateBtn.setImageResource(R.drawable.chocolate)
        binding.jellyBtn.setImageResource(R.drawable.jelly)

        when(pivot){
            1->{
                binding.lollipopBtn.setImageResource(R.drawable.selected)
                candies_name="Lollipop"
                candies_image=R.drawable.lollipop
                candies_price=5000
            }
            2->{
                binding.pepperBtn.setImageResource(R.drawable.selected)
                candies_name="Pepper Mint"
                candies_image=R.drawable.pepper
                candies_price=8000
            }
            3->{
                binding.gumBtn.setImageResource(R.drawable.selected)
                candies_name="Gum Candy"
                candies_image=R.drawable.gum
                candies_price=2000
            }
            4->{
                binding.candyBtn.setImageResource(R.drawable.selected)
                candies_name="Original Candy"
                candies_image=R.drawable.candy
                candies_price=1000
            }
            5->{
                binding.chocolateBtn.setImageResource(R.drawable.selected)
                candies_name="Chocolate"
                candies_image=R.drawable.chocolate
                candies_price=10000
            }
            6->{
                binding.jellyBtn.setImageResource(R.drawable.selected)
                candies_name="Jelly Bean"
                candies_image=R.drawable.jelly
                candies_price=5000
            }
        }

    }


}