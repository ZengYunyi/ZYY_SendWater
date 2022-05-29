package com.example.zyy_sendwater.ui.myview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/16 10:20
 */
class CircleRectView : View {
    var mPaint:Paint ?= null
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        mPaint= Paint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint?.shader = null//清除之前的配置
        mPaint?.isAntiAlias = true//抗锯齿
        mPaint?.isDither = true//防抖动

        //半径，缩小40半径
        var outerRedius : Float = if(width<height) width.toFloat() else height/2f-40
        var centerX = getWidth()/2f
        var centerY = getHeight()/2f

        mPaint?.style = Paint.Style.FILL
        var count=0
        var des = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,5f,resources.displayMetrics)
        while (count++<50){
            canvas?.drawRect(centerX-3,centerX
                    -outerRedius,centerX+3,centerY-outerRedius+des,mPaint!!)
            canvas?.rotate(10.0f,centerX,centerY)
        }
    }

    fun setDotColor(color:Int){
        mPaint?.setColor(color)
        invalidate()
    }
}