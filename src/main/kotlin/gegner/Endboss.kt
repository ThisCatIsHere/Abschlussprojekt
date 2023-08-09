package gegner

import helden.Helden
import minibossSpawnt


class Endboss(name: String) : Gegner(name) {
    var seelenRaub: Int = 300 //soll alle helden treffen
    var seelenAnker: Int = 250
    var seelenFluch: Int = 100 //soll nur einen helden treffen
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

    fun seelenFluch(helden: Helden) {
        helden.lebenspunkte -= seelenFluch
        println("Molag Bal verflucht einen Helden")

    }
    fun seelenZange(helden: Helden) {
        helden.lebenspunkte -= seelenZange
        println("Molag Bal schingt seine Seelen Zange")
    }

    fun wuetendesSchnauben(helden: Helden) {
        helden.lebenspunkte -= wuetendesSchnauben
        println("Molag Bal schnaubt wütend und sein Atem trifft einen Helden")
    }
    fun verloreneSeele() {
        if (!minibossSpawnt) {
            minibossSpawnt = true
        }
    }
    fun verloreneSeeleSpawnt() {
        if (lebenspunkte <= 500 / 2 && verloreneSeele == null) {
            verloreneSeele = Miniboss("Seelen Leibeigener", wenigerLeben = 500)
            println("Molag Bal ruft seinen Seelenleibeigenen herbei!")
        }
    }

}