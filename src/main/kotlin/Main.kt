package com.gaboscm

import com.gaboscm.problems.LexicographicallySmallestStringAfteraSwap
import com.gaboscm.problems.MinimumStepByStepSum

fun main() {
    //val minimunValueStepByStepSum = MinimumStepByStepSum()
    //println(minimunValueStepByStepSum.minStartValue(intArrayOf(-4,-1,1,-5,-4,5,5)))
    val lexicographicallySmallestStringAfteraSwap = LexicographicallySmallestStringAfteraSwap()
    println(lexicographicallySmallestStringAfteraSwap.getSmallestString("45320"))
    println(lexicographicallySmallestStringAfteraSwap.getSmallestString("02"))
}

