package gameboy

fun parseOperation(line: String): Operation {
    val parts = line.trim().split(" ")
    val opName = parts.first()
    val numberPart = parts.last().toInt()

    return when (opName){
        "acc" -> Operation(numberPart, 1)
        else -> Operation(0, 1)
    }
}