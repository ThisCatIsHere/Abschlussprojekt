package endboss

import held1
import held2
import held3
import helden.Helden
import heldenListe
import miniboss

class Miniboss(name: String, wenigerLeben: Int) : Gegner(name, lebenspunkte = 1000 - wenigerLeben) {

    var wenigerLeben: Int = 500

    var kleinerSeelenraub: Int = 200 // trifft random einen Held
    var welleDerAngst: Int = 150 // trifft alle Helden
    var streitkolbenDerSeelenlosen: Int = 100 // trifft random einen Held
    var seelenSpaehre: Int = 50


    fun kleinerSeelenraub() {
        var randomHeld: Helden = heldenListe.random()
        randomHeld.lebenspunkte -= miniboss.kleinerSeelenraub
    }

    fun welleDerAngst() {
        held1.lebenspunkte -= miniboss.welleDerAngst
        held2.lebenspunkte -= miniboss.welleDerAngst
        held3.lebenspunkte -= miniboss.welleDerAngst
    }

    fun streitkolbenDerSeelenlosen() {
        var randomHeld: Helden = heldenListe.random()
        randomHeld.lebenspunkte -= miniboss.streitkolbenDerSeelenlosen

    }

    fun seelenspaehre() {
        var randHeld: Helden = heldenListe.random()
        randHeld.lebenspunkte -= miniboss.seelenSpaehre
    }

    fun minibossAttacke() {
        var randomattack = listOf<Int>(1, 2, 3, 4, 5, 6).random()
        when (randomattack) {
            1 -> kleinerSeelenraub()
            2 -> welleDerAngst()
            3 -> streitkolbenDerSeelenlosen()
            4 -> seelenspaehre()

        }
    }
}