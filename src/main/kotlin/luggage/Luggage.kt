package luggage

class Luggage(bags: List<Bag>) {
    val bags = bags.associateBy { it.id }

    init {
        this.bags.values.forEach { bag ->
            bag.updateChildren(this.bags)
        }
    }

}