package com.gaboscm.problems

class MaximumDifference {
    private fun Int.toDigits(): List<Int> = toString().map { it.toString().toInt() }
    data class NumberReplace(val numberToReplace: Int, val newNumber: Int) {}
    fun minMaxDifference(num: Int): Int {
        if (num.toDigits().isEmpty()) return 0
        return getNumberWithReplacement(findNumberToReplaceForMax(num.toDigits()), num.toDigits()) - getNumberWithReplacement(
            findNumberToReplaceForMin(num.toDigits()), num.toDigits()
        )
    }

    private fun findNumberToReplaceForMax(numbers: List<Int>): NumberReplace {
        return findNumberReplace(numbers, 9)
    }

    private fun findNumberToReplaceForMin(numbers: List<Int>): NumberReplace {
        return findNumberReplace(numbers, 0)
    }

    private fun findNumberReplace(numbers: List<Int>, valueToReplace: Int): NumberReplace {
        var replaceValue: Int? = null
        var index = 0
        while (index < numbers.size) {
            if (numbers[index] == valueToReplace){
                index++
                continue
            }
            else{
                replaceValue = valueToReplace
                break
            }
        }
        return if (replaceValue == null)
            NumberReplace(valueToReplace, valueToReplace)
        else
            NumberReplace(numbers[index], replaceValue)
    }

    private fun getNumberWithReplacement(numberReplace: NumberReplace, numbers: List<Int>): Int {
        return numbers
            .map {
                if (it == numberReplace.numberToReplace)
                    numberReplace.newNumber.toString()
                else
                    it.toString()
            }.reduce { acc: String, digit: String -> acc + digit }.toInt()
    }
}