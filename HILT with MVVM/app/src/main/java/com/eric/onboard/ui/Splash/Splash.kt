package com.eric.onboard.ui.Splash

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.eric.onboard.R
import com.eric.onboard.databinding.SplashBinding


class Splash : Fragment(R.layout.splash) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding: SplashBinding = SplashBinding.bind(view)
        val animationDrawable = binding.layout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(400)
        animationDrawable.setExitFadeDuration(400)
        animationDrawable.start()

        goToNext()


    }



    private fun goToNext(){

    }


}