package com.example.zyy_sendwater.util

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/30 15:15
 */
class Vp2TransformerOverlay: ViewPager2.PageTransformer {
    private val MIN_SCALE = 0.75f
    override fun transformPage(page: View, position: Float) {
        var pageWidth = page.width

        when {
            position < -1 -> { // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f
            }
            position <= 0 -> { // [-1,0]
                // Use the default slide transition when moving to the left page
                page.alpha = 1F
                page.translationX = 0f
                page.scaleX = 1f
                page.scaleY = 1f
            }
            position <= 1 -> { // (0,1]
                // Fade the page out.
                page.alpha = 1 - position

                // Counteract the default slide transition
                page.translationX = pageWidth * -position

                // Scale the page down (between MIN_SCALE and 1)
                val scaleFactor: Float = (MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - abs(position)))
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
            }
            else -> { // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f
            }
        }
    }
}