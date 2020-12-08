package gameboy

data class Operation(val accInc: Int, val indexInc: Int = 1, var hasRun: Boolean = false)