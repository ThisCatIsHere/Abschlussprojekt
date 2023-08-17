package Handwerksbeutel

// Neue Basisklasse "Item" erstellt, für den Beutel
open class Item(var name:String, var wert: Int) {

    override fun toString(): String {
        return "Name: $name, Wert: $wert"
    }

}