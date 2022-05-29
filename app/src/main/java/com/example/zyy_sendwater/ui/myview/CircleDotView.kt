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
 * @date :2022/4/16 9:24
 * 进度条外圈
 */
class CircleDotView : View{
    var mSin_1: Double ? =null
    var mPaint : Paint ?= null
    var width: Float? = null
    var height:Float? = null
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        this.mPaint = Paint()
    }
    //TypedValue：Android自身提供的单位换算类，DP/DIP/DX屏幕单位换算
    fun setWidth(witdh : Float){
        //将外界设置的看作dp为单位计算
        var w=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,witdh,resources.displayMetrics)
        this.width = w
    }
    fun setHeight(height : Float){
        this.height = height
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var width = measurtWidth(widthMeasureSpec)
        var height = measurtHeight(heightMeasureSpec)
        //设置宽高
        setMeasuredDimension(width,height)
    }
    fun measurtWidth(measureSpec: Int):Int{
        val specMode = MeasureSpec.getMode(measureSpec)//获取当前的模式，比如固定尺寸，或者warp_content
        val specSize = MeasureSpec.getSize(measureSpec)//获取当前的宽度
//        when(specMode){
//            MeasureSpec.AT_MOST-> //wrap_content
//            MeasureSpec.EXACTLY->//fill_parent
//            MeasureSpec.UNSPECIFIED->//精确值
//        }
        return specSize
    }

    fun measurtHeight(measureSpec: Int):Int{
        val specMode = MeasureSpec.getMode(measureSpec)//获取当前的模式，比如固定尺寸，或者warp_content
        val specSize = MeasureSpec.getSize(measureSpec)//获取当前的宽度
//        when(specMode){
//            MeasureSpec.AT_MOST-> //wrap_content
//            MeasureSpec.EXACTLY->//fill_parent
//            MeasureSpec.UNSPECIFIED->//精确值
//        }
        return specSize
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //计算sin1的值
        mSin_1 = Math.sin(Math.toRadians(1.0))
        //大圆半径
        var outerRadius : Float = if(getWidth()<getHeight()) getWidth().toFloat() else getHeight()/2F

        //小圆点半径
        var dotRadius = mSin_1!! *outerRadius / (1+ mSin_1!!)
        //获取大圆圆心
        var centerX = getWidth()/2f
        var centerY = getHeight()/2f

        mPaint?.style = Paint.Style.FILL
        var count = 0
        while (count++ < 50){
            canvas?.drawCircle(centerX,
                (centerY-outerRadius+dotRadius).toFloat(), dotRadius.toFloat(), mPaint!!)
            canvas?.rotate(7.2F,centerX,centerY)
        }
    }
    fun setDotColor(color:Int){
        mPaint?.setColor(color)
        invalidate()
    }

}