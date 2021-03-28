package com.bhavesh.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bhavesh.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.user = UserModel("Bhavesh", "Joshi","bhaveshjoshi@gmail.com")
        binding.author = UserModel("Aaa","Bbb", "Ccc@ddd.efg")

    }
}