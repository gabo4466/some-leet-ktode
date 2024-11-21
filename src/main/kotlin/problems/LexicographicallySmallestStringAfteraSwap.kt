package com.gaboscm.problems

import java.util.Collections

class LexicographicallySmallestStringAfteraSwap {
    fun getSmallestString(s: String): String {
        val chars = s.toCharArray()

        for (i in 0.rangeUntil(chars.size - 1)) {
            if (chars[i].digitToInt() > chars[i + 1].digitToInt() && chars[i].digitToInt() % 2 == chars[i + 1].digitToInt() % 2) {
                val temp = chars[i]
                chars[i] = chars[i + 1]
                chars[i + 1] = temp
                return String(chars)
            }
        }
        return s
    }
}