package gegner

import helden.Helden
import heldenListe
import minibossSpawnt
import kotlin.random.Random


class Endboss(name: String,lebenspunkte: Int) : Gegner(name,lebenspunkte) {
    var maxLebenspunkte: Int = 1000
    var seelenRaub: Int = 300 //soll alle helden treffen
    var seelenAnker: Int = 250
    var seelenFluch: Int = 100 //soll nur einen helden treffen,//10% pro Held, pro runde bis HP weniger als 20%
    var seelenZange: Int = 50
    var wuetendesSchnauben: Int = 25
    var verloreneSeele: Miniboss? = null //erst wenn der Endboss nur noch 50% leben hat


    fun seelenRaub(held1: Helden, held2: Helden, held3: Helden) {
        held1.lebenspunkte -= seelenRaub
        held2.lebenspunkte -= seelenRaub
        held3.lebenspunkte -= seelenRaub

        println("Molag Bal greift alle Helden mit seinem Seelenraub an")
    }

    fun seelenAnker(helden: Helden) {
        helden.lebenspunkte -= seelenAnker
        println("Molag Bal schmettert seinen Seelen Anker zu den Helden")
    }


//    fun seelenFluch(helden: Helden) {
//        helden.lebenspunkte -= seelenFluch
//        println("Molag Bal verflucht einen Helden")}


    fun seelenFluch() {
        var randomHeld = heldenListe.random() //Boolean anlegen und jede Runde abfragen, ob
        var zwanzigProzent = false
        //In der Variable steht die jeweilige LP des Helden drin
        var heldLP20 = (randomHeld.lebenspunkte * 0.2).toInt()
        while (!zwanzigProzent){
            if (randomHeld.lebenspunkte != heldLP20){
                randomHeld.lebenspunkte -= seelenFluch
                println("Molag Bal verflucht den Helden ${randomHeld.name}")
                println(randomHeld.lebenspunkte)
            }else {
                zwanzigProzent = true
            }
        }

    }

    fun seelenFluchSchaden(helden: Helden){

    }
    fun seelenZange(helden: Helden) {
        helden.lebenspunkte -= seelenZange
        println("Molag Bal schingt seine Seelen Zange")
    }

    fun wuetendesSchnauben(helden: Helden) {
        helden.lebenspunkte -= wuetendesSchnauben
        println("Molag Bal schnaubt wütend und sein Atem trifft einen Helden")
    }

    fun verloreneSeeleSpawnt() {
        if (lebenspunkte <= 500 && !minibossSpawnt) {
            verloreneSeele = Miniboss("Seelen Leibeigener", wenigerLeben = 500)
            println("Molag Bal ruft seinen Seelenleibeigenen herbei!")
            minibossSpawnt = true
        }
    }

    fun endbossAttacke(){

    }
}