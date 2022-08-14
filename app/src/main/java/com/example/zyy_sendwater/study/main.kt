package com.example.zyy_sendwater.study

/**
 * @author ZengYunyi
 * @packageName com.example.zyy_sendwater.study
 * @description: zyy21
 * @date :2022/7/21 22:07
 */

fun main() {
//    print(sum(y=2))
//    val list = toList("java","kotlin","scala","groovy")
//    print(list)
//    var array = arrayOf("java","kotlin","scala","groovy")
//    toList() 也可以传递数组，不过不能像 Java 那样直接传递数组。需要使用展开运算符*(在参数名前加*)，它表示解包数组，能够让数组中的每个元素在函数中被作为单独的参数。
//    var list = toList(*array)
//    print(list)
    sumRecursion(100)
    print(sumRecursions)
}
//Kotlin 的可变参数与 Java 的可变参数类似，但是 Kotlin 需要对参数使用vararg进行修饰。
//Kotlin 的可变参数一般是函数的最后一个参数。
//如果可变参数不是函数的最后一个参数，那么后面的参数需要通过命名参数来传值：
fun <T> toList(vararg items: T) :List<T>{
    val result = ArrayList<T>()
    for(item in items)
        result.add(item)
    return result
}

fun sum(x: Int=0,y: Int):Int{
    return x + y
}

//@JvmOverloads：由于使用了默认参数之后，可以避免重载。但是 Java 却无法调用，
//因为对 Java 而言只会对一个方法可见，它是所有参数都存在的完整参数签名的方法。
//如果希望也向 Java 调用者暴露多个重载，可以使用 @JvmOverloads 注解。

//@JvmStatic：表示该方法为静态方法。Kotlin 可以为对象声明或者伴生对象中定义的函数使用@JvmStatic。
// (上述例子 RxJavaUtils 即为对象声明，对象声明和伴生对象会在下一小节详细介绍)

//返回Unit的函数
//如果函数不需要返回任何内容就函数返回Unit对象，可以被省略函数后面不跟任何参数默认Unit
//返回Nothing 在 Nothing 的表达式之后的所有代码都是无法执行的。

//当函数返回单个表达式时，可以省略函数体的花括号
//例子
fun singSum(x:Int = 0,y: Int):Int{
    return x + y
}
//可以是
fun singSum1(x:Int = 0,y: Int):Int = x+y
//也可以是
fun singSum2(x:Int = 0,y: Int) = x + y

//尾递归函数
//这是因为在 Kotlin 中使用尾递归函数，需要满足两个条件：
//使用tailrec关键词修饰函数
//在函数最后进行递归调用
//使用tailrec关键词之后，编译器会优化该递归，从而避免了堆栈溢出的风险。
//递归全部偶数
var sumRecursions:Int = 0;
tailrec fun sumRecursion(n:Int):Int = if (!(n > 0)) sumRecursions else{
    sumRecursions += n
    sumRecursion(n-1)
}
