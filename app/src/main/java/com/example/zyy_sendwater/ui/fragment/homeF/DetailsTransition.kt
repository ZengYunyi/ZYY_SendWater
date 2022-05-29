package com.example.zyy_sendwater.ui.fragment.homeF

import android.transition.*

/**
 * @author ZengYunyi
 * @description: zyy21
 * @date :2022/4/13 9:51
 */
class DetailsTransition : TransitionSet() {
    fun DetailsTransition(){
        setOrdering(ORDERING_TOGETHER)
        addTransition(ChangeBounds())
            .addTransition(ChangeTransform())
            .addTransition(ChangeImageTransform())
    }
}