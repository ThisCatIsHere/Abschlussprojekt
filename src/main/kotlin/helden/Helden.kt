package helden


//Hier habe ich eine neue Basisklasse für die Helden erstellt.
open class Helden(var name: String, var lebenspunkte: Int = 750, var lebtHeldNoch: Boolean) {

    // Eine Variable, um die maximalen Lebenspunkte des Helden zu speichern.
    var maxLebenspunkte = lebenspunkte



    // Eine Methode, die berechnet, wie viele Lebenspunkte der Held verloren hat.
    fun verloreneLebenspunkte(): Int {
        return maxLebenspunkte - lebenspunkte
    }



}

