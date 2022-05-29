package com.example.zyy_sendwater.ui.myview

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.annotation.RequiresApi
import com.example.zyy_sendwater.R


/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/16 10:36
 */
class CircleProgressView : View{
    //外圆画笔
    var firstPaint: Paint? = null
    var textColor : Int ?=null

    //进度条最大值，默认一百
    var maxValue = 100

    //当前进度条
    var currentValue = 0

    //每次扫过的角度，用来设置进度条圆弧所对应的圆心角。alphaAngle=（currentValue/maxValue）*360
    var alphaAngle: Float? = null

    //圆弧的颜色，默认为Color。LTGRAY
    var firstColor: Int? = null
    //进度条圆弧的颜色
    var secondColor: Int? = null
    //圆环的宽度
    var circleWidth: Int? = null
    //画圆弧的画笔
    var circlePaint: Paint? = null
    //画文字的画笔
    var textPaint: Paint? = null
    //渐变圆周颜色数组
    var colorArray= longArrayOf(Color.parseColor("#27B297").toLong(),Color.parseColor("#00A6D5").toLong())
    //通过代码创建时才使用
    constructor(context: Context?) : super(context,null)
    //通过view创建时才会被调用，attrs包含的是xml文件定义控件时传入的属性
    /**
     * 从xml加载时执行和应用一个特定的风格。这里有两种方式，一是从theme中获得，二是从style中获得。
     * 第三个参数官方有这样的说明： defStyle - The default style to apply to this view. If 0,
     * no style will be applied (beyond what is included in the theme). This may
     * either be an attribute resource, whose value will be retrieved from the
     * current theme, or an explicit style resource.
     * 默认的风格会被应用到这个view上。如果是0，没有风格将会被应用
     * （除了被包含在主题中）。这个也许是一个属性的资源，它的值是从当前的主题中检索，或者是一个明确的风格资源。
     *
     * @param context
     *            上下文
     * @param attrs
     *            自定义的属性
     * @param defStyleAttr
     *            自定义风格
     */
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs,0)
    @SuppressLint("ResourceAsColor")
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        var ta: TypedArray? = context?.theme?.obtainStyledAttributes(attrs, R.styleable.circleProgressBar,defStyleAttr,0)
        var n : Int ?= ta?.indexCount
        //这些属性值都是在xml中声明才会生效，若没有在xml文件中声明的话，n就为0
        for (i in 0..n!!){
            var attr=ta?.getIndex(i)
            if(attr == R.styleable.circleProgressBar_firstColor){
                firstColor = ta?.getColor(attr,Color.LTGRAY)//默认底色为亮灰色
            }else if(attr == R.styleable.circleProgressBar_secondColor){
                secondColor = ta?.getColor(attr,R.color.defaultcolor)
            }else if(attr == R.styleable.circleProgressBar_circleWidth){
                circleWidth = ta?.getDimensionPixelSize(attr,TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,6f,resources.displayMetrics).toInt())
            }else if(attr == R.styleable.circleProgressBar_circleWidth){
                textColor = ta?.getColor(attr,Color.BLACK)
            }
        }
        ta?.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        var measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        //分别获取期望的宽度和高度，并取其中较小的尺寸作为该控件的宽和高
        setMeasuredDimension(Math.min(measureWidth,measureHeight),Math.min(measureWidth,measureHeight))
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onDraw(canvas: Canvas?) {
        var des=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,1f,resources.displayMetrics)
        var center = this.width/2f
        var radius = center - circleWidth!! / 2f-40+des
        firstPaint = Paint()
        firstPaint?.isAntiAlias = true
        firstPaint?.isDither = true
        firstPaint?.strokeWidth = 2f
        firstPaint?.setColor(firstColor!!)

        circlePaint = Paint()
        circlePaint?.isAntiAlias = true
        circlePaint?.isDither = true
        circlePaint?.strokeWidth = circleWidth?.toFloat()!!

        textPaint = Paint()
        textPaint?.isAntiAlias = true
        textPaint?.isDither = true
        //绘制进度圆弧
        drawCircle(canvas, center,radius)
//        drawText(canvas, center)
    }
    /***
     * 绘制进度圆弧
     * canvas画布对象
     * center圆心的x和y的坐标
     * radius圆的半径
     */
    @RequiresApi(Build.VERSION_CODES.Q)
    fun drawCircle(canvas: Canvas?, center:Float?, redius:Float?){
        //画一个简单的圆
//        firstPaint?.setShader(null)//清除上一次的shader
//        firstPaint?.color = firstColor!!//设置底部圆环的颜色，这里使用第一种颜色
//        firstPaint?.style = Paint.Style.STROKE//绘制的圆形为空心
//        canvas?.drawCircle(center!!, center, (redius!!+20),firstPaint!!)

        //画一个圆环
        var oval = RectF(center!!-redius!!,center-redius,center+redius,center+redius)
        circlePaint?.setShader(null)
        //绘制颜色渐变圆环
        //shader类是Android在图形变换中非常重要的一个类，shader在三维软件中我们称之为着色器，给图像着色
        var linearGradient = LinearGradient(circleWidth?.toFloat()!!,
            circleWidth?.toFloat()!!,(measuredWidth-circleWidth!!).toFloat(),(measuredWidth-circleWidth!!).toFloat(),Color.parseColor("#1296db"),Color.parseColor("#E0E0E0"),Shader.TileMode.MIRROR)
        circlePaint?.shader = linearGradient
        //这里注意色设置为描边类型
        circlePaint?.style = Paint.Style.STROKE
        //设置阴影
        circlePaint?.setShadowLayer(10f,5f,5f,Color.RED)
        //设置圆弧颜色
        circlePaint?.color = secondColor!!
        //把每段圆弧都改成圆角
        circlePaint?.strokeCap = Paint.Cap.ROUND
        //计算每次画圆弧时扫过的角度，这里计算要注意分母转为float类型，否则alphaAngle将永远为0
        alphaAngle = currentValue*360.0f / maxValue*1.0f
        //画弧线
        canvas?.drawArc(oval,-90f,alphaAngle!!,false, circlePaint!!)
    }

    /*
    * 绘制文字
    * canvas画布对象
    * center圆心xy
    * radius 圆的半径
    * */
    fun drawText(canvas: Canvas?, center: Float){
        //计算进度
        var result=(currentValue*100f/maxValue*1f)
        var percent= String.format("%.1f",result)+"%"

        textPaint?.textAlign = Paint.Align.CENTER//设置文字居中，文字的x坐标需要注意
        textPaint?.color= textColor!!//设置文字颜色
        textPaint?.textSize=40f
        textPaint?.strokeWidth=0f//注意圆点要设置宽度为0，否则绘制的文字会重叠
        var bounds=Rect()//文字边框
        textPaint?.getTextBounds(percent,0,percent.length,bounds)//获得绘制文字的边界矩形
        var fontMetrics = textPaint?.fontMetricsInt//获取绘制Text时的四条线
        var baseline: Float = center + (fontMetrics?.bottom!!- fontMetrics.top)/2 - fontMetrics.bottom
        canvas?.drawText(percent, center, baseline,textPaint!!)
    }

    //设置圆弧的宽度
    fun setCircleWidth(width:Int){
        this.circleWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,width.toFloat(),resources.displayMetrics).toInt()
        circlePaint?.strokeWidth = circleWidth?.toFloat()!!
        invalidate()
    }
    //设置圆弧的底色，默认为亮灰色LTGRAY
    fun setFirstColor(color:Int){
        this.firstColor  = color
        circlePaint?.color = firstColor!!
        invalidate()
    }

    //设置进度条的颜色，默认为蓝色
    fun setSecondColor(color:Int){
        this.secondColor  = color
        circlePaint?.color = secondColor!!
        invalidate()
    }

    fun setTextColor(color:Int){
        this.textColor  = color
        textPaint?.color = textColor!!
        invalidate()
    }

    //设置进度条渐变色颜色数组
    fun setColorsArray(colors:LongArray){
        this.colorArray = colors
        invalidate()
    }
    /*
    * 按进度显示百分比
    * progress进度值通常为0到100
    * */
    fun setProgress(progress:Int){
        var percent = progress * maxValue/100
        if(percent<0){
            percent = 0
        }
        if(percent>100){
            percent = 100
        }
        this.currentValue = percent
        invalidate()
    }
    /*
    * 按进度显示百分比，可选择是否启动数值动画
    *   progress进度值通常为0到100
    *   useAnimation是否启用动画，true为启用
    * */
    fun setProgress(progress:Int,useAnimtion:Boolean){
        var percent = progress * maxValue/100
        if(percent<0){
            percent = 0
        }
        if(percent>100){
            percent = 100
        }
        //使用动画
        if(useAnimtion){
            var animator = ValueAnimator.ofInt(0,percent)
            animator.addUpdateListener {
                currentValue = it.animatedValue as Int
                invalidate()
            }
            animator.interpolator = OvershootInterpolator()
            animator.duration = 100
            animator.start()
        }else{
            setProgress(progress)
        }
    }
}