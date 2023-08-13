package endboss

import helden.Helden
import heldenListe

class Miniboss(name: String, wenigerLeben: Int) : Gegner(name, lebenspunkte = 1000 - wenigerLeben) {

    var wenigerLeben: Int = 500

    var kleinerSeelenraub: Int = 200 // trifft random einen Held
    var welleDerAngst: Int = 150 // trifft alle Helden
    var streitkolbenDerSeelenlosen: Int = 100 // trifft random einen Held
    var seelenSpaehre: Int = 50
}

fun kleinerSeelenraub(helden: Helden, miniboss: Miniboss) {
    var randomHeld: Helden = heldenListe.random()
    randomHeld.lebenspunkte -= miniboss.kleinerSeelenraub
}

fun welleDerAngst(held1: Helden, held2: Helden, held3: Helden, miniboss: Miniboss) {
    held1.lebenspunkte -= miniboss.welleDerAngst
    held2.lebenspunkte -= miniboss.welleDerAngst
    held3.lebenspunkte -= miniboss.welleDerAngst
}

fun streitkolbenDerSeelenlosen(helden: Helden, miniboss: Miniboss) {
var randomHeld: Helden = heldenListe.random()
    randomHeld.lebenspunkte -= miniboss.streitkolbenDerSeelenlosen

}

fun seelenspaehre(helden: Helden, miniboss: Miniboss){
    var randHeld: Helden = heldenListe.random()
    randHeld.lebenspunkte -= miniboss.seelenSpaehre
}
