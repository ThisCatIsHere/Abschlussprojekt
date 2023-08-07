package gegner

class Miniboss(name: String, wenigerLeben: Int) : Gegner(name, lebenspunkte = 5000 - wenigerLeben){

    var wenigerLeben: Int = 2500
    var kleinerSeelenraub: Int = 200
    var welleDerAngst: Int = 150
    var streitkolbenDerSeelenlosen: Int = 100
    var seelenSpaehre: Int = 50
}