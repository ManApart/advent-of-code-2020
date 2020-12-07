package luggage

class Bag(val id: String, val contents: Map<String, Int>) {
    val parents = mutableListOf<Bag>()

    fun updateChildren(bags: Map<String, Bag>) {
        contents.keys.forEach { childId ->
            bags[childId]?.parents?.add(this)
        }
    }
}