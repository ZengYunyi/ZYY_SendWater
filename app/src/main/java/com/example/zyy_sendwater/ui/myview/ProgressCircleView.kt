package com.example.zyy_sendwater.ui.myview

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import com.example.zyy_sendwater.R

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/16 9:05
 */
class ProgressCircleView : FrameLayout {
    var textColor: Int? = null

    var circleColor: Int? = null
    var circleDotWidth: Int? = null
    var circleRectWidth: Int? = null
    var circleNumberRingWidth: Int? = null
    var circleRectColor = 0
    var circleDotColor = 0
    var circleNumderColor = 0
    var circleNumderWitdh = 0
    var circleNumderView : CircleNumderView? = null
    var circleRectView : CircleRectView? = null
    var circleDotView: CircleDotView? = null

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs,0)
    @SuppressLint("ResourceAsColor")
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        var ta=context.theme.obtainStyledAttributes(attrs, R.styleable.progressCircleView,defStyleAttr,0)
        var n=ta.indexCount
        var size_150dp = pxTodp(150)
        var size_170dp = pxTodp(170)
        var size_4dp = pxTodp(4)

        //若xml没有设置以下属性，则使用默认值
        circleDotWidth = size_170dp
        circleRectWidth = size_170dp
        circleNumderWitdh = size_150dp
        circleNumberRingWidth = size_4dp
        circleColor = R.color.defaultcolor
        circleRectColor = R.color.defaultcolor
        circleDotColor = R.color.defaultcolor
        circleNumderColor = R.color.defaultcolor
        textColor = R.color.defaultcolor

        for(i in 0..n){
            var attr = ta.getIndex(i)
            if(attr == R.styleable.progressCircleView_circleNumberWidth){
                circleNumderWitdh = ta.getDimension(attr,size_150dp.toFloat()).toInt()
            }else if(attr==R.styleable.progressCircleView_circleRectWidth){
                circleRectWidth = ta.getDimension(attr,size_150dp.toFloat()).toInt()
            }else if(attr==R.styleable.progressCircleView_circleDotWidth){
                circleDotWidth = ta.getDimension(attr,size_170dp.toFloat()).toInt()
            }else if(attr==R.styleable.progressCircleView_circleNumberColor){
                circleNumderColor = ta.getColor(attr,R.color.defaultcolor)
            }else if(attr==R.styleable.progressCircleView_circleDotColor){
                circleDotColor = ta.getColor(attr,R.color.defaultcolor)
            }else if(attr==R.styleable.progressCircleView_circleRectColor){
                circleRectColor = ta.getColor(attr,R.color.defaultcolor)
            }else if(attr==R.styleable.progressCircleView_circleColor){
                circleColor = ta.getColor(attr,R.color.defaultcolor)
            }else if(attr==R.styleable.progressCircleView_textColor){
                textColor = ta.getColor(attr,R.color.defaultcolor)
            }
        }

        circleDotView = CircleDotView(context,null)
        var dotParams = LayoutParams(circleDotWidth!!, circleDotWidth!!)
        dotParams.gravity = Gravity.CENTER
        circleDotView!!.layoutParams = dotParams
        circleDotView!!.setDotColor(circleDotColor)

        circleRectView = CircleRectView(context,null)
        var rectParmas = LayoutParams(circleRectWidth!!, circleRectWidth!!)
        rectParmas.gravity = Gravity.CENTER
        circleRectView!!.layoutParams = rectParmas
        circleRectView!!.setDotColor(circleRectColor)

        this.addView(circleDotView)
        this.addView(circleRectView)

        var animator = ObjectAnimator.ofFloat(circleDotView,"rotation",0f,360f)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        animator.duration = 7000
        animator.start()

        animator = ObjectAnimator.ofFloat(circleRectView,"rotation",360f,0f)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.duration = 8000
        animator.interpolator = LinearInterpolator()
        animator.start()

        circleNumderView = CircleNumderView(context,null)
        var numberParams = LayoutParams(circleNumderWitdh,circleNumderWitdh)
        Log.i("dawhuidwad", "witdh: "+circleNumderWitdh)
        numberParams.gravity = Gravity.CENTER
        circleNumderView!!.layoutParams = numberParams
        circleNumderView!!.secondColor = circleNumderColor
        circleNumderView!!.circleWidth = circleNumberRingWidth
        circleNumderView!!.firstColor = circleColor
        circleNumderView!!.textColor = textColor
        this.addView(circleNumderView)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var width = measure(widthMeasureSpec)
        var heigth = measure(heightMeasureSpec)
        setMeasuredDimension(width,heigth)
    }

    fun measure(measureSpec: Int):Int{
        var specMode = MeasureSpec.getMode(measureSpec)
        var specSize = MeasureSpec.getSize(measureSpec)
        var base = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200f,resources.displayMetrics)
        //wrap_content
        if(specMode == MeasureSpec.AT_MOST){
            specSize = base.toInt()
            //fill_parent或者精确值
        }else if(specMode == MeasureSpec.EXACTLY){

        }
        return specSize
    }

    fun pxTodp(px:Int):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,px.toFloat(),resources.displayMetrics).toInt()
    }


    fun setProgress(progress:Int){
        circleNumderView?.setProgress(progress,false)
    }
}