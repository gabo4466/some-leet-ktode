package com.gaboscm.problems

class MinimumStepByStepSum {
    fun minStartValue(nums: IntArray): Int {
        var startValue = 1
        var sum = startValue
        for (num in nums) {
            sum += num
            if (sum <= 0) {
                startValue += (sum * -1) + 1
                sum=1
            }
        }
        return startValue
    }
}