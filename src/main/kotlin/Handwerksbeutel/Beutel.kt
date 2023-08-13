package Handwerksbeutel

open class Beutel(){

    var inventar: MutableList<Item> = mutableListOf()

    init {
        repeat(3){
            var heiltrank = Heiltrank("HP Potion", 50)
            inventar.add(heiltrank)
        }
        var vitaminbombe = Vitaminbombe("Power", 10)
        inventar.add(vitaminbombe)
    }

    fun addItem(item: Item) {
        inventar.add(item)
    }

    fun getItem(): List<Item> {
        return inventar.toMutableList()

    }
}