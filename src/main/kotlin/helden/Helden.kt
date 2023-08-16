package helden



open class Helden(var name: String, var lebenspunkte: Int = 750, var lebtHeldNoch: Boolean) {

    var maxLebenspunkte = lebenspunkte



    fun verloreneLebenspunkte(): Int {
        return maxLebenspunkte - lebenspunkte
    }



}

