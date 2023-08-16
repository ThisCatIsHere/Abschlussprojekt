package helden

import held1

open class Helden(var name: String, var lebenspunkte: Int = 750, var lebtHeldNoch: Boolean) {

    var maxLebenspunkte = lebenspunkte



    fun verloreneLebenspunkte(): Int {
        return maxLebenspunkte - lebenspunkte
    }


    fun lebenspunkteCheck(helden: Helden) { //noch nicht fertig
        if (helden.lebenspunkte <= 0)
            helden.lebenspunkte = 0
        helden.lebtHeldNoch = false
    }
}

