package endboss

import held
import held2
import held3
import helden.Helden
import heldenListe
import miniboss
import red
import reset

class Miniboss(name: String, wenigerLeben: Int) : Gegner(name, lebenspunkte = 1000 - wenigerLeben) {

    var wenigerLeben: Int = 450

    var kleinerSeelenraub: Int = 200 // trifft random einen Held
    var welleDerAngst: Int = 150 // trifft alle Helden
    var streitkolbenDerSeelenlosen: Int = 100 // trifft random einen Held
    var seelenSpaehre: Int = 50


    fun kleinerSeelenraub() {
        var randomHeld: Helden = heldenListe.random()
        randomHeld.lebenspunkte = maxOf(randomHeld.lebenspunkte - miniboss.kleinerSeelenraub, 0)
        println(red+"Der Leibeigene trifft ${randomHeld.name} und fügt ihm $kleinerSeelenraub Schaden zu!"+reset)
    }

    fun welleDerAngst() {
        held.lebenspunkte = maxOf(held.lebenspunkte - miniboss.welleDerAngst, 0)
        held2.lebenspunkte = maxOf(held2.lebenspunkte - miniboss.welleDerAngst, 0)
        held3.lebenspunkte = maxOf(held3.lebenspunkte - miniboss.welleDerAngst, 0)
        println(red+"Der Leibeigene stößt eine Welle der Angst aus und trifft alle Helden mit einem Schaden von $welleDerAngst!"+reset)
    }

    fun streitkolbenDerSeelenlosen() {
        var randomHeld: Helden = heldenListe.random()
        randomHeld.lebenspunkte = maxOf(randomHeld.lebenspunkte - miniboss.streitkolbenDerSeelenlosen, 0)
        println(red+"Der Streitkolben der Seelenlosen trifft ${randomHeld.name} und fügt ihm $streitkolbenDerSeelenlosen Schaden zu!"+reset)
    }

    fun seelenspaehre() {
        var randomHeld: Helden = heldenListe.random()
        randomHeld.lebenspunkte = maxOf(randomHeld.lebenspunkte - miniboss.seelenSpaehre, 0)
        println(red+"Eine Seelenspähre trifft ${randomHeld.name} und fügt ihm $seelenSpaehre Schaden zu!"+reset)
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