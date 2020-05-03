package subtask1

import kotlin.math.absoluteValue

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) {
            return null
        }

        numbers.reverse()
        var result = ""

        for (x in numbers.indices) {
            result = getMember(x, numbers[x]) + result
        }


        return result.substring(3)
    }

    private fun getMember(order: Int, value: Int): String = if (value != 0) {
        when (order) {
            0 -> getValue(value)
            1 -> getValue(value) + "x"
            else -> getValue(value) + "x^$order"
        }
    } else ""

    private fun getValue(value: Int): String = when {
        value == 0 -> ""
        value > 0 -> " + ${if (value != 1) value else ""}"
        else -> " - ${if (value != -1) value.absoluteValue else ""}"
    }
}
