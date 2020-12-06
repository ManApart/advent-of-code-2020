package customs

fun countAnswersForCustoms(lines: List<String>): Int {
    return parseCustoms(lines).sumBy { countAnswersPerGroup(it) }
}

fun countAllAnswersForCustoms(lines: List<String>): Int {
    return parseCustoms(lines).sumBy { countAnswersThatAllAnsweredInGroup(it) }
}

fun countAnswersPerGroup(group: List<String>): Int {
    return group.flatMap { it.toCharArray().toList() }.toSet().size
}

fun countAnswersThatAllAnsweredInGroup(group: List<String>): Int {
    val answerCount = mutableMapOf<Char, Int>()
    group.forEach { person ->
        person.toCharArray().toSet().forEach { answer ->
            if (!answerCount.containsKey(answer)) {
                answerCount[answer] = 0
            }
            answerCount[answer] = answerCount[answer]!! + 1
        }
    }

    return answerCount.keys.filter { answerCount[it] == group.size }.count()
}