package com.gokul.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    // Defining a bottomSheetBehaviour instance
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the BottomSheetBehaviour
        bottomSheetBehavior = BottomSheetBehavior.from(R.id.bottomSheet as ConstraintLayout)

        //Listening to state changes of bottomsheet
        bottomSheetBehavior.addBottomSheetCallback(object:BottomSheetBehavior.BottomSheetCallback(){
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                TODO("Not yet implemented")
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                (R.id.btnBottomSheetpresistent as Button).text = when(newState){
                    BottomSheetBehavior.STATE_EXPANDED -> "Close Presistent Bottom Sheet"
                    BottomSheetBehavior.STATE_COLLAPSED -> "OPen Presistent Bottom Sheet"
                    else -> "Persistent bottom Sheet"
                }
            }
        })

        // Changing The bottomsheet state on ButtonClick
        (R.id.btnBottomSheetpresistent as Button).setOnClickListener{
            val state =
                    if(bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {BottomSheetBehavior.STATE_COLLAPSED}
                    else{BottomSheetBehavior.STATE_EXPANDED}

        }
    }
}