package helden

open class Helden(var name:String, var lebenspunkte: Int = 750, var angriff: Int = 100){

    var maxLebenspunkte = lebenspunkte

    fun verloreneLebenspunkte(): Int {
        return maxLebenspunkte - lebenspunkte
    }

}

