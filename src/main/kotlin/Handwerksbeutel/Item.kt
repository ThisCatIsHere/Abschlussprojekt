package Handwerksbeutel

open class Item(var name:String, var wert: Int) {

    override fun toString(): String {
        return "Name: $name, Wert: $wert"
    }

}