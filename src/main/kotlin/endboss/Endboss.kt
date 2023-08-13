package endboss

import held1
import held2
import held3
import helden.Helden
import heldenListe
import minibossSpawnt


class Endboss(name: String,lebenspunkte: Int) : Gegner(name,lebenspunkte) {
    var maxLebenspunkte: Int = 1000
    var seelenRaub: Int = 300 //soll alle helden treffen
    var seelenAnker: Int = 250
    var seelenFluch: Int = 100 //soll nur einen helden treffen,//10% pro Held, pro runde bis HP weniger als 20%
    var seelenZange: Int = 50
    var wuetendesSchnauben: Int = 25
    var verloreneSeele: Miniboss? = null //erst wenn der Endboss nur noch 50% leben hat


    fun seelenRaubausfuehren(held1: Helden, held2: Helden, held3: Helden) {
        held1.lebenspunkte -= seelenRaub
        held2.lebenspunkte -= seelenRaub
        held3.lebenspunkte -= seelenRaub

        println("Molag Bal greift alle Helden mit seinem Seelenraub an und fügte Ihnen allen jeweils $seelenRaub Schaden zu!")
    }

    fun seelenAnker() {
        var randomHeld = heldenListe.random()
        randomHeld.lebenspunkte -= seelenAnker
        println("Molag Bal schmettert seinen Seelen Anker zu ${randomHeld.name} und fügt ihm $seelenAnker Schaden zu!")
    }


    fun seelenFluch() {
        var randomHeld = heldenListe.random()

        var zwanzigProzent = false
        //In der Variable steht die jeweilige LP des Helden drin
        var heldLP20 = (randomHeld.lebenspunkte * 0.2).toInt()
        while (!zwanzigProzent){
            if (randomHeld.lebenspunkte > heldLP20){
                randomHeld.lebenspunkte -= seelenFluch
                println("Molag Bal verflucht den Helden ${randomHeld.name}")
                println(randomHeld.lebenspunkte)
            }else {
                zwanzigProzent = true
            }
        }

    }

    fun seelenZange() {
    var randomHeld = heldenListe.random()
        randomHeld.lebenspunkte -= seelenZange
        println("Molag Bal schwingt seine Seelen Zange und trifft ${randomHeld.name} und fügt ihm $seelenZange Schaden zu!")
    }

    fun wuetendesSchnauben() {
        var randomHeld = heldenListe.random()
        randomHeld.lebenspunkte -= wuetendesSchnauben
        println("Molag Bal schnaubt wütend und sein Atem trifft ${randomHeld.name} und fügt ihm $wuetendesSchnauben Schaden zu!")
    }

    fun verloreneSeeleSpawnt() {
        if (lebenspunkte <= 500 && !minibossSpawnt) {
            verloreneSeele = Miniboss("Seelen Leibeigener", wenigerLeben = 500)
            println("Molag Bal ruft seinen Seelenleibeigenen herbei!")
            minibossSpawnt = true
        }
    }

    fun endbossAttacke(){
        var randomattack = listOf<Int>(1,2,3,4,5,6).random()
        when(randomattack){
            1-> seelenRaubausfuehren(held1, held2, held3) //Flächenschaden vom Endboss
            2-> seelenAnker()
            3-> seelenFluch()
            4-> seelenZange()
            5-> wuetendesSchnauben()
            6-> verloreneSeeleSpawnt()
        }
    }
}