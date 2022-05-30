package com.example.zyy_sendwater.util

import android.view.View
import androidx.viewpager2.widget.ViewPager2

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/30 15:15
 */
class Vp2Transformer: ViewPager2.PageTransformer {
    private val MIN_SCALE = 0.75f
    override fun transformPage(page: View, position: Float) {
        var pageWidth = page.width

        if(position<-1){
            page.alpha = 0f
        }else if(position <= 0){
            page.apply {
                alpha = 1f
                translationX = 0f
                scaleX = 1f
                scaleY = 1f
            }
        }else if(position <= 1){
            page.apply {
                alpha = 1-position
                translationX = pageWidth*-position
                var scaleFactor = MIN_SCALE+(1-MIN_SCALE)*(1-Math.abs(position))
                scaleX = scaleFactor
                scaleY = scaleFactor
            }
        }
    }
}