import endboss.Endboss
import endboss.Miniboss

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

fun heldenMenue(): Any? {
    println("Wähle deinen Helden:")
    println("In Klammern stehen die aktuellen Lebenspunkte")
    println("1 = Khajit (${held1.lebenspunkte}) | 2 = Ork (${held2.lebenspunkte}) | 3 = Dunkelelf (${held3.lebenspunkte}) | 4 = Abbrechen")

    var userInput: Int
    userInput = try {
        readLine()?.toInt() ?: 0
    } catch (e: NumberFormatException) {
        0
    }

    return when (userInput) {
        1 -> {
            held1.battlemenueKhajit(endboss)

        }

        2 -> {
            held2.battlemenueOrk(endboss)

        }

        3 -> {
            held3.battlemenueDunkelelf(endboss)

        }


        else -> {
            println("Ungültige Eingabe. Bitte wähle 1 - 4.")
            heldenMenue()
        }
    }
}

//Die Funktion wurde mithilfe von Chat Gpt erstellt
fun kampfRunde() {
    var counter: Int = 1
    while (!gameOver(endboss, held1, held2, held3)) {

        if (!minibossSpawnt && endboss.lebenspunkte > endboss.maxLebenspunkte / 2) {
            minibossSpawnt = true
            println("Molag Bal ruft einen Seelen Leibeigenen herbei...")
            miniboss.minibossAttacke()

        }

        else if (endboss.lebenspunkte > 0) {

            println("...und wartet welcher Held sich ihm zuerst stellen wird...")
            println("")
            println("-------------------  $counter Runde beginnt ---------------------")

            if (minibossSpawnt && miniboss.lebenspunkte > 0) {
                println("Molag Bal zieht sich zurück und lässt seinen Leibeignen kämpfen.")
                println("Der Seelenleibeigene erscheint und greift die Helden an")
                miniboss.minibossAttacke()
                heldenMenue()
                heldenMenue()
                heldenMenue()

                held1.hatSchonAngegriffen = false
                held2.hatSchonAngegriffen = false
                held3.hatSchonAngegriffen = false

            } else {

                heldenMenue()
                heldenMenue()
                heldenMenue()
                println("..........................................................")
                endboss.endbossAttacke()
                held1.hatSchonAngegriffen = false
                held2.hatSchonAngegriffen = false
                held3.hatSchonAngegriffen = false

            }

            println("")


        }
        counter += 1
    }

    println("Das Spiel ist vorbei.")
}

fun gameOver(endboss: Endboss, held1: Khajit, held2: Ork, held3: Dunkelelf): Boolean {

    if ((held1.lebenspunkte <= 0) && (held2.lebenspunkte <= 0) && (held3.lebenspunkte <= 0)) {
        println("Game Over, Molag Bal hat Eure Helden besiegt!")
        return true


    } else if (endboss.lebenspunkte <= 0) {
        println("Gewonnen! Du hast Molag Bal besiegt")
        return true

    }

    return false
}



