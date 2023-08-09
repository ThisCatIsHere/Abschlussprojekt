package gegner

import helden.Helden
import minibossSpawnt


class Endboss(name: String) : Gegner(name) {
    var seelenRaub: Int = 300 //soll alle helden treffen
    var seelenAnker: Int = 250
    var seelenFluch: Int = 100 //soll nur einen helden treffen
    var seelenZange: Int = 50
    var wuetendesSchnauben: Int = 25
    var verloreneSeele: Miniboss = Miniboss("Seelen Leibeigener", wenigerLeben = 500)//erst wenn der Endboss nur noch 50% leben hat


    fun seelenRaub(held1: Helden, held2: Helden, held3: Helden) {
        held1.lebenspunkte -= seelenRaub
        held2.lebenspunkte -= seelenRaub
        held3.lebenspunkte -= seelenRaub

        println("Hier kommt noch ein schöner Text hin")
    }

    fun seelenAnker(helden: Helden) {
        helden.lebenspunkte -= seelenAnker
        println("Text")
    }
    // ? Noch nicht fertig (wie kann ich rundenbasierten schaden hinzufügen?)
    fun seelenFluch(helden: Helden) {
        helden.lebenspunkte -= seelenFluch
        println("Text")

    }
    fun verloreneSeele(){
        if(!minibossSpawnt){
            // ? Objekt Miniboss muss noch generiert werden
            minibossSpawnt = true
        }
    }


}