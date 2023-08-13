import endboss.Endboss
import endboss.Miniboss
import endboss.minibossAttacke
import helden.Dunkelelf
import helden.Helden
import helden.Khajit
import helden.Ork

var minibossSpawnt = false


var held1 = Khajit("Nachtklinge")
var held2 = Ork("Horak", extraLebenspunkte = 150)
var held3 = Dunkelelf("Anarwen", wenigerLeben = 250)

var endboss = Endboss("MolagBal", 1000)
var miniboss = Miniboss("Seelen Leibeigener", wenigerLeben = 500)

var heldenListe = mutableListOf<Helden>(held1, held2, held3)
var randomHeld = heldenListe.random()

fun heldenMenue(): Helden? {
    println("Wähle deinen Helden:")
    println("1 = Khajit | 2 = Dunkelelf | 3 = Ork | 4 = Abbrechen")

    var userInput: Int
    userInput = try {
        readLine()?.toInt() ?: 0
    } catch (e: NumberFormatException) {
        0
    }

    return when (userInput) {
        1 -> Khajit("Khajit")
        2 -> Dunkelelf("Dunkelelf", wenigerLeben = 250)
        3 -> Ork("Horak", 200)
        4 -> null

        else -> {
            println("Ungültige Eingabe. Bitte wähle 1 - 4.")
            heldenMenue()
        }
    }
}

//Die Funktion wurde mithilfe von Chat Gpt erstellt
fun kampfRunde() {

    while (!gameOver(endboss, held1, held2, held3)) {

        if (endboss.lebenspunkte > endboss.maxLebenspunkte / 2) {
            println("Molag Bal greift an!")
            println("")
            endboss.endbossAttacke()
            println("")
            heldenMenue() //Bis hier hin läuft es

        } else if (!minibossSpawnt) {
            minibossSpawnt = true
            println("Molag Bal ruft einen Seelen Leibeigenen herbei...")
            endboss.verloreneSeeleSpawnt()
            endboss.verloreneSeele?.let {
                println("Miniboss erscheint")
                minibossAttacke()
            }
        } else {
            println("Molag Bal erscheint")
            endboss.endbossAttacke()
        }
        println("Das Spiel ist vorbei.")
    }
}


fun gameOver(endboss: Endboss, held1: Khajit, held2: Ork, held3: Dunkelelf): Boolean {
    if ((held1.lebenspunkte == 0) && (held2.lebenspunkte == 0) && (held3.lebenspunkte == 0)) {
        return true
    }
    return false
}



