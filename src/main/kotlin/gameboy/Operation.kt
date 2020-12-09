package gameboy

class Operation(val type: String, val number: Int, var hasRun: Boolean = false) {
    val accInc: Int = when(type) {
        "acc" -> number
        else -> 0
    }
    val indexInc: Int = when(type) {
        "jmp" -> number
        else -> 1
    }
}