package com.eric.onboard.ui.Splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.eric.onboard.R
import com.eric.onboard.databinding.SplashBinding

class Splash : Fragment(R.layout.splash) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding: SplashBinding = SplashBinding.bind(view)

        goToNext()


    }
    private fun goToNext(){

    }


}