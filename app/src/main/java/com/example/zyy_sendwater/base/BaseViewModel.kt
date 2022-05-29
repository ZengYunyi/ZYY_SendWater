package com.example.zyy_sendwater.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/5/20 13:49
 */
abstract class BaseViewModel : ViewModel(){

    fun <T> getFlow(block:suspend()->T) : Flow<T> = flow { emit(block.invoke()) }

    //单请求
    fun <T> launchNetWork(requestBlock:suspend()->T,
        resultCallback:suspend (T)->Unit){
        viewModelScope.launch {
            flow {
                emit(requestBlock.invoke())
            }.catch {
                it.printStackTrace()
            }.collect {
                resultCallback(it)
            }
        }
    }
    //zip请求
    fun <T> launchZip(response1: Flow<T>,response2: Flow<T>,
        resultCallback:(T,T)->Unit){
        response1.zip(response2){
            response1,response2->
            Pair(response1,response2)
        }.catch {
            it.printStackTrace()
        }.onEach {
            resultCallback(it.first,it.second)
        }
    }
//    合并请求combine
    fun <T> launchCombine(block:Flow<Array<T>>,resultCallback:(Array<T>)->Unit) {
        block.catch {
            it.printStackTrace()
        }.onEach {
            resultCallback(it)
        }
    }


}