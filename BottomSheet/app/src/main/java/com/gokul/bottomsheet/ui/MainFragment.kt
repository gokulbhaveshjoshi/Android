package com.gokul.bottomsheet.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.gokul.bottomsheet.R
import com.gokul.bottomsheet.ui.model.ModalBottomSheet
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.persistent_bottom_sheet.*

@Suppress("DEPRECATION")
class MainFragment: Fragment(R.layout.main_fragment) {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetBehavior = BottomSheetBehavior.from<LinearLayout>(persistent_bottom_sheet)
        bottom()
    }

    private fun bottom() {

        bottomSheetDialogBtn.setOnClickListener{
            val nullParent: ViewGroup? = null
            val modalSheetView = layoutInflater.inflate(R.layout.fragment_modal_bottom_sheet,nullParent)
            val dialog = context?.let { it1 -> BottomSheetDialog(it1) }
            dialog?.setContentView(modalSheetView)
            dialog?.show()

        }

        bottomSheetDialogFragmentBtn.setOnClickListener {
            val modalbottomSheetFragment = ModalBottomSheet()
            modalbottomSheetFragment.show(childFragmentManager,modalbottomSheetFragment.tag)
        }

        bottomSheetBehavior.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, state: Int) {
                print(state)
                when (state) {

                    BottomSheetBehavior.STATE_HIDDEN -> {
                        persistentBtn.text = "Show Bottom Sheet"
                    }
                    BottomSheetBehavior.STATE_EXPANDED ->
                        persistentBtn.text = "Close Bottom Sheet"
                    BottomSheetBehavior.STATE_COLLAPSED ->
                        persistentBtn.text = "Show Bottom Sheet"
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {

                    }
                }
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })

        persistentBtn.setOnClickListener {
            expandCollapseSheet()
        }
    }


    private fun expandCollapseSheet() {
        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            persistentBtn.text = "Close Bottom Sheet"
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            persistentBtn.text = "Show Bottom Sheet"
        }
    }
}