package luggage

fun parseAndCountLuggageAncestors(bagId: String, lines: List<String>): Int {
    return Luggage(parseLuggage(lines)).countAllAncestors(bagId)
}


class Luggage(bags: List<Bag>) {
    val bags = bags.associateBy { it.id }

    init {
        this.bags.values.forEach { bag ->
            bag.updateChildren(this.bags)
        }
    }

    fun countAllAncestors(bagId: String): Int {
        return getAllAncestors(bagId).count()
    }

    fun getAllAncestors(bagId: String): List<Bag> {
        val ancestors = mutableSetOf<Bag>()
        val open = bags[bagId]!!.parents

        while (open.isNotEmpty()) {
            val current = open.first()
            open.remove(current)
            ancestors.add(current)
            open.addAll(current.parents)
        }

        return ancestors.toList()
    }

    fun countAllDescendants(bagId: String): Long {
        return countAllDescendantsRecursive(bagId, 1)
    }

    private fun countAllDescendantsRecursive(bagId: String, multiplier: Int): Long {
        return bags[bagId]!!.contents.entries.sumByLong { entry ->
            val countOfThisBag = entry.value * multiplier
            val countOfChildren = countAllDescendantsRecursive(entry.key, entry.value * multiplier)
            countOfThisBag + countOfChildren
        }
    }

}


inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
    var sum = 0L
    for (element in this) {
        sum += selector(element)
    }
    return sum
}