package subtask4

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 0) {
            return null
        }

        val longNumber = number.toLong()
        val decomposeArr = decompose(longNumber, longNumber * longNumber)

        if (decomposeArr != null) {
            val result = mutableListOf<Int>()
            decomposeArr.remove(decomposeArr.last())

            decomposeArr.forEach {
                result.add(it.toInt())
            }

            return result.toTypedArray()
        }

        return null
    }

    private fun decompose(current: Long, rest: Long): MutableList<Long>? {
        if (rest == 0L) {
            return mutableListOf(current)
        }

        for (x in current - 1 downTo 0) {
            val diff = rest - x * x

            if (diff >= 0) {
                val resultList = decompose(x, diff)

                if (resultList != null) {
                    resultList.add(current)

                    return resultList
                }
            }
        }

        return null
    }
}
