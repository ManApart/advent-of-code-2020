package gameboy

private const val timeout = 100000000

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

fun findAccAtByFiddlingOps(operations: List<Operation>): Int {
    operations.forEachIndexed { index, operation ->
//        if (operation.type == "nop"){
//            val newOP = Operation("jmp", 0, 1)
//            val spliced = findAccAtProgramComplete(newOP, index, operations)
//            if (spliced != -1){
//                return spliced
//            }
//        } else if (operation.type == "jmp"){
//            val newOP = Operation("jmp", 0, 1)
//            val spliced = findAccAtProgramComplete(newOP, index, operations)
//            if (spliced != -1){
//                return spliced
//            }
//        }
    }

    return -1
}

private fun findAccAtProgramComplete(newOp: Operation, indexToReplace: Int, operations: List<Operation>) : Int {
    val newOperations = operations.subList(0, indexToReplace) + listOf(newOp) + operations.subList(indexToReplace, operations.size)
    return findAccAtProgramComplete(newOperations)
}


fun findAccAtProgramComplete(operations: List<Operation>): Int {
    var acc = 0
    var index = 0
    var i = 0

    while (i < timeout && index < operations.size) {
        i++
        val operation = operations[index]
        if (operation.hasRun) {
            return -1
        }
        acc += operation.accInc
        index += operation.indexInc
        operation.hasRun = true
    }
    return acc
}