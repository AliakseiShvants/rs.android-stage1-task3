package subtask5

private const val X = 4
private const val Y = 3

class TelephoneFinder {
    private val digitArr: Array<Array<Char>> = arrayOf(
        arrayOf('1', '2', '3'),
        arrayOf('4', '5', '6'),
        arrayOf('7', '8', '9'),
        arrayOf('x', '0', 'x')
    )

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.toInt() < 0) {
            return null
        }

        val result = mutableListOf<String>()

        number.forEachIndexed { index, symbol ->
            val place = getPlace(symbol)

            for (x in place.first - 1..place.first + 1 step 2) {
                if (x in 0 until X) {
                    val newSymbol = getSymbol(Pair(x, place.second))

                    if (newSymbol.isDigit()) {
                        result.add(number.replace(number[index], newSymbol))
                    }
                }
            }

            for (y in place.second - 1..place.second + 1 step 2) {
                if (y in 0 until Y) {
                    val newSymbol = getSymbol(Pair(place.first, y))

                    if (newSymbol.isDigit()) {
                        result.add(number.replace(number[index], newSymbol))
                    }
                }
            }
        }

        return result.toTypedArray()
    }

    private fun getPlace(digit: Char): Pair<Int, Int> {
        var first = 0
        var second = 0

        digitArr.forEachIndexed { index, symbolArr ->
            if (symbolArr.contains(digit)) {
                first = index
                second = symbolArr.indexOf(digit)
            }
        }

        return Pair(first, second)
    }

    private fun getSymbol(pair: Pair<Int, Int>): Char {
        return digitArr[pair.first][pair.second]
    }
}
