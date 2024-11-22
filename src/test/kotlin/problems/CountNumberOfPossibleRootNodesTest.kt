package problems

import com.gaboscm.problems.CountNumberOfPossibleRootNodes
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CountNumberOfPossibleRootNodesTest {
    @ParameterizedTest
    @MethodSource("testData")
    fun givenAValidInputAndOutput_whenCountingPossibleRootNodes_thenCorrectResult(
        edges: Array<IntArray>,
        guesses: Array<IntArray>,
        k: Int,
        expectedOutput: Int
    ) {
        val subject = CountNumberOfPossibleRootNodes()

        val result = subject.rootCount(edges, guesses, k)

        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun testData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(4, 2)),
                    arrayOf(intArrayOf(1, 3), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(2, 4)),
                    3,
                    3
                ),
                Arguments.of(
                    arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4)),
                    arrayOf(intArrayOf(1,0), intArrayOf(3,4), intArrayOf(2,1), intArrayOf(3,2)),
                    1,
                    5
                ),
            )
        }
    }
}