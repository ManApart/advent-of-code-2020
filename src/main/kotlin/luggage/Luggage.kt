package luggage

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

        while (open.isNotEmpty()){
            val current = open.first()
            open.remove(current)
            ancestors.add(current)
            open.addAll(current.parents)
        }

        return ancestors.toList()
    }

}