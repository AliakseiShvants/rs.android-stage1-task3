package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val numbers = getArrOfSortedNumberOrSkip(itemsFromArray)

        if (numbers.isEmpty()) {
            return 0
        }

        if (numberOfItems >= numbers.size) {
            return mulAll(numbers)
        }

        var negativeCount = numbers.take(numberOfItems).filter { it < 0 }.count()

        while (negativeCount % 2 == 1 && numbers.size > numberOfItems) {
            val element = numbers.last { it < 0 }

            numbers.removeAt(numbers.indexOf(element))
            negativeCount = numbers.filter { it < 0 }.count()
        }

        var result = numbers[0]

        for (x in 1 until numberOfItems) {
            result *= numbers[x]
        }

        return result
    }

    private fun getArrOfSortedNumberOrSkip(itemsFromArray: Array<Any>): MutableList<Int> {
        var result = mutableListOf<Int>()

        itemsFromArray.forEach {
            if (it is Int) result.add(it)
        }

        result.sortBy { it.absoluteValue }
        result.reverse()

        return result
    }

    private fun mulAll(numbers: List<Int>): Int {
        var result = numbers[0]

        for (x in 1 until numbers.size) {
            result *= numbers[x]
        }

        return result
    }
}
