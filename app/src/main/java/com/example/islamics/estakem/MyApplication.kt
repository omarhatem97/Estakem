package com.example.islamics.estakem

import android.app.Application
import android.content.SharedPreferences

class MyApplication:Application()
{

    companion object {

        var checked:Int = 0
        var globalvar :MutableMap<String,Pair<String,String>> ?=null
        var keyname:String = ""
    }

}