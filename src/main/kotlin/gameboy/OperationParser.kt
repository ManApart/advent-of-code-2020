package gameboy

fun parseOperations(lines: List<String>): List<Operation> {
    return lines.map { parseOperation(it) }
}


fun parseOperation(line: String): Operation {
    val parts = line.trim().split(" ")
    val opName = parts.first()
    val numberPart = parts.last().toInt()

    return Operation(opName, numberPart)
}