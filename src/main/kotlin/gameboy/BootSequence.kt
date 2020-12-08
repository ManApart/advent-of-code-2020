package gameboy

private val timeout = 100000000

fun findAccAtLoopStart(operations: List<Operation>): Int {
    var acc = 0
    var index = 0
    var i = 0

    while (i < timeout) {
        i++
        val operation = operations[index]
        if (operation.hasRun) {
            return acc
        }
        acc += operation.accInc
        index += operation.indexInc
        operation.hasRun = true
    }
    return 0
}