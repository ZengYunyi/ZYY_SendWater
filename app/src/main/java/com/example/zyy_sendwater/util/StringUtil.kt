package com.example.zyy_sendwater.util

import com.example.zyy_sendwater.study.toList

/**
 * @author ZengYunyi
 * @packageName com.example.zyy_sendwater.util
 * @description: zyy21
 * @date :2022/8/14 10:53
 */

fun ABC():List<Char> = toList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')

fun ABC(string: String):List<String> = toList(string,"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")