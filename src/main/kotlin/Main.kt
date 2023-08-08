import gegner.Endboss
import gegner.Miniboss
import helden.Dunkelelf
import helden.Khajit
import helden.Ork
import kotlin.system.exitProcess


fun main() {

    var held1 = Khajit("Nachtklinge")
    var held2 = Ork("Horak", extraLebenspunkte = 150)
    var held3 = Dunkelelf("Anarwen", wenigerLeben = 250)
    var endboss = Endboss("MolagBal")
    var miniboss = Miniboss(
        "Seelen Leibeigener", wenigerLeben = 2500)

    println("Willkommen zum ESO RPG-Game")
    var menue = listOf("1. Neues Spiel", "2. Spiel beenden")


    do {
        println("    ============== Menü ==============")
        println("==== 1.Neues Spiel --- 2.Spiel beenden ====")
        println("Drücke Taste 1 oder 2")
        var userInput: Int
        userInput = try {
            readLine()?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            0
        }

        // Menüoptionen
        when (userInput) {
            1 -> {
                neuesSpiel()
            }

            2 -> {
                println("Auf Wiedersehen!")
                exitProcess(0)

            }

            else -> {
                println("Ungültige Eingabe. Bitte wähle eine Option (1 oder 2).")
            }
        }
    } while (userInput != 2)
}

fun neuesSpiel() {
    var isGameOver = false
    println("Neues Spiel wird gestartet...")


    while (!isGameOver) {
        val selectedHero = heldenMenue()

        if (selectedHero == null) {
            println("Du hast dich entschieden abzubrechen. Auf Wiedersehen!")
            break

        } else if (selectedHero is Khajit) {
            val endboss = Endboss("Molag Bal")
            var miniboss = Miniboss("Seelen Leibeigener", wenigerLeben = 2500)
            battlemenueKhajit(selectedHero, endboss)

        } else if (selectedHero is Dunkelelf) {
            val endboss = Endboss("Molag Bal")
            var miniboss = Miniboss("Seelen Leibeigener", wenigerLeben = 2500)
            battlemenueDunkelelf(selectedHero, endboss)

        } else if (selectedHero is Ork) {
            val endboss = Endboss("Molag Bal")
            var miniboss = Miniboss("Seelen Leibeigener", wenigerLeben = 2500)
            battlemenueOrk(selectedHero, endboss)
        }


    }
}






