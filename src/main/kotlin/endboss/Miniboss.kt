package endboss

import held
import held2
import held3
import helden.Helden
import heldenListe
import miniboss
import red
import reset

class Miniboss(name: String) : Gegner(name, lebenspunkte = 500) {


    // trifft random einen Held
    var kleinerSeelenraub: Int = 200
    // trifft alle Helden
    var welleDerAngst: Int = 150
    // trifft random einen Held
    var streitkolbenDerSeelenlosen: Int = 100
    // trifft random einen Held
    var seelenSpaehre: Int = 50


    fun kleinerSeelenraub() {
        // Zufällige Auswahl eines Helden aus der Liste der Helden
        var randomHeld: Helden = heldenListe.random()
        // Verringert die Lebenspunkte des ausgewählten Helden um den Schaden des kleineren Seelenraubs
        randomHeld.lebenspunkte = maxOf(randomHeld.lebenspunkte - miniboss.kleinerSeelenraub, 0)
        println(red+"Der Leibeigene trifft ${randomHeld.name} und fügt ihm $kleinerSeelenraub Schaden zu!"+reset)
    }

    fun welleDerAngst() {
        // Verringert die Lebenspunkte aller Helden um den Schaden der Welle der Angst
        held.lebenspunkte = maxOf(held.lebenspunkte - miniboss.welleDerAngst, 0)
        held2.lebenspunkte = maxOf(held2.lebenspunkte - miniboss.welleDerAngst, 0)
        held3.lebenspunkte = maxOf(held3.lebenspunkte - miniboss.welleDerAngst, 0)
        println(red+"Der Leibeigene stößt eine Welle der Angst aus und trifft alle Helden mit einem Schaden von $welleDerAngst!"+reset)
    }

    fun streitkolbenDerSeelenlosen() {
        // Zufällige Auswahl eines Helden aus der Liste der Helden
        var randomHeld: Helden = heldenListe.random()
        // Verringert die Lebenspunkte des ausgewählten Helden um den Schaden des Streitkolbens der Seelenlosen
        randomHeld.lebenspunkte = maxOf(randomHeld.lebenspunkte - miniboss.streitkolbenDerSeelenlosen, 0)
        println(red+"Der Streitkolben der Seelenlosen trifft ${randomHeld.name} und fügt ihm $streitkolbenDerSeelenlosen Schaden zu!"+reset)
    }

    fun seelenspaehre() {
        // Zufällige Auswahl eines Helden aus der Liste der Helden
        var randomHeld: Helden = heldenListe.random()
        // Verringert die Lebenspunkte des ausgewählten Helden um den Schaden der Seelenspähre
        randomHeld.lebenspunkte = maxOf(randomHeld.lebenspunkte - miniboss.seelenSpaehre, 0)
        println(red+"Eine Seelenspähre trifft ${randomHeld.name} und fügt ihm $seelenSpaehre Schaden zu!"+reset)
    }

    fun minibossAttacke() {
        //Zufällige Auswahl einer Angriffsaktion
        var randomattack = listOf<Int>(1, 2, 3, 4, 5, 6).random()
        // Je nach zufälliger Angriffsaktion wird eine entsprechende Funktion aufgerufen
        when (randomattack) {
            1 -> kleinerSeelenraub()
            2 -> welleDerAngst()
            3 -> streitkolbenDerSeelenlosen()
            4 -> seelenspaehre()

        }
    }
}