package com.example.zyy_sendwater

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/15 18:54
 */
class CollapsibelToolbar @JvmOverloads constructor(
    context: Context,attrs: AttributeSet?=null,defStyleAttr:Int = 0
):MotionLayout(context,attrs,defStyleAttr),AppBarLayout.OnOffsetChangedListener{
    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
    }
}