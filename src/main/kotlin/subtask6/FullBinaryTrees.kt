package subtask6

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        var result = emptyArray<String>()

        return when {
            count % 2 == 0 -> "[]"
            count == 1 -> "[[0]]"
            count == 3 -> "[[0,0,0]]"
            else -> {
                ""
            }
        }
    }
}
