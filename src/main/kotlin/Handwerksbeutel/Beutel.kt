package Handwerksbeutel

class Beutel(name:String) : Item(name) {
    var items = mutableListOf<Item>()

    fun addItem(item: Item) {
     items.add(item)
    }

    fun getItem(): List<Item> {
        return items.toMutableList()

    }
}