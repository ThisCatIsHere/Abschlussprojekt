package helden

import gegner.Gegner

open class Helden(var name:String, var lebenspunkte: Int = 1000, var angriff: Int = 100){

// *Muss evtl später noch woanders hingepackt werden
    var handwerksbeutel: MutableMap<String, Int> = mutableMapOf(
        "Heiltrank1" to 50,
        "Heiltrank2" to 50,
        "Heiltrank3" to 50,
        "Vitaminbombe" to 10
    )

}

