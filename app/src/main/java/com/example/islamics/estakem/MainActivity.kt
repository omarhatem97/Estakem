package com.example.islamics.estakem

import android.content.Context
import android.content.Intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView


import android.widget.RelativeLayout

import android.view.View
import android.widget.GridLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
{

    var context:Context = this


    override fun onCreate(savedInstanceState: Bundle?)
    {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val grid = mainGrid as GridLayout
        val childCount = grid.getChildCount()

        for (i in 0 until childCount) {
            val container = grid.getChildAt(i) as CardView
            container.setOnClickListener {
                if(i == 0) {
                    val intent = Intent(context, mychallenges::class.java)
                    startActivity(intent)
                } else if(i == 1) {
                    val intent = Intent(context, ershadat::class.java)
                    startActivity(intent)
                } else if(i == 2) {
                    val intent = Intent(context , farayed::class.java)
                    intent.putExtra("name","farayed")
                    startActivity(intent)
                } else if(i == 3) {
                    val intent = Intent(context, engazat::class.java)
                    startActivity(intent)
                } else if(i == 4) {
                    val intent = Intent(context , farayed::class.java)
                    intent.putExtra("name","sonan_mahgora")
                    startActivity(intent)
                } else if(i == 5) {
                    val intent = Intent(context , farayed::class.java)
                    intent.putExtra("name","nwafel")
                    startActivity(intent)
                } else if(i == 6) {
                    val intent = Intent(context ,tarkzanb::class.java)
                    intent.putExtra("mystate","mine")
                    startActivity(intent)
                } else if(i== 7) {
                    val intent = Intent(this ,tarkzanb::class.java)
                    intent.putExtra("mystate","mine")
                    startActivity(intent)
                } else if(i == 8){
                    val intent = Intent(context ,tarkzanb::class.java)
                    intent.putExtra("mystate","znb")
                   startActivity(intent)
                }
            }
        }



    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    //---------------------------------


}

