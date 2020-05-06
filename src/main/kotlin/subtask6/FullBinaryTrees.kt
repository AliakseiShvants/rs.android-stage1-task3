package subtask6

class FullBinaryTrees {

    private val empty = "[0]"
    private val base = "[0,0,0]"

    fun stringForNodeCount(count: Int): String {
        val result = when {
            count % 2 == 0 -> emptyArray()
            count == 1 -> arrayOf(empty)
            count == 3 -> arrayOf(base)
            else -> {


                emptyArray()
            }
        }

        return printArr(result)
    }

    private fun printArr(array: Array<String>): String {
        return array.joinToString(prefix = "[", postfix = "]") { it }
    }
}
