package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val value = fuctorial(array[1]) / array[0]

        for (x in 1 until array[1]) {
            val result = fuctorial(x) * fuctorial(array[1] - x)

            if (result == value) return x
        }

        return null
    }

    private fun fuctorial(number: Int): Long {
        var result = 1L

        for (x in 1..number) {
            result *= x
        }

        return result
    }
}
