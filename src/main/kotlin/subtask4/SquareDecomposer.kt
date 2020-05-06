package subtask4

import kotlin.math.floor
import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 0) {
            return null
        }

        var result = mutableListOf<Int>()
        result.add(number - 1)

        val diff0: Double = (2 * number - 1).toDouble()
        val start = floor(sqrt(diff0)).toInt()

        for (x in start downTo 1) {
            var tempList = mutableListOf<Int>()
            var diff: Double = diff0 - x * x
            tempList.add(x)


            while (diff > 0) {
                val item = floor(sqrt(diff)).toInt()
                tempList.add(item)
                diff -= item * item
            }

            if (isIncrease(tempList)) {
                result.addAll(tempList)
                result.sort()

                return result.toTypedArray()
            }
        }

        return null
    }

    private fun isIncrease(tempList: MutableList<Int>) = tempList.size == tempList.toSet().size
}
