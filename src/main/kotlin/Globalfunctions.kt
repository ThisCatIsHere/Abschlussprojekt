import gegner.Endboss
import gegner.Miniboss
import helden.Dunkelelf
import helden.Helden
import helden.Khajit
import helden.Ork

var minibossSpawnt = false

var held1 = Khajit("Nachtklinge")
var held2 = Ork("Horak", extraLebenspunkte = 150)
var held3 = Dunkelelf("Anarwen", wenigerLeben = 250)

var endboss = Endboss("MolagBal")
var miniboss = Miniboss("Seelen Leibeigener", wenigerLeben = 2500)




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




