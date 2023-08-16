import Handwerksbeutel.Beutel
import Handwerksbeutel.Item
import endboss.Endboss
import endboss.Gegner
import endboss.Miniboss

import helden.Dunkelelf
import helden.Helden
import helden.Khajit
import helden.Ork

var minibossSpawnt = false
var red = "\u001B[31m"
var green = "\u001B[32m"
var yellow = "\u001B[33m"
var cyan = "\u001B[36m"
var magenta = "\u001B[35m"

var reset = "\u001B[0m"

var held1 = Khajit("Nachtklinge")
var held2 = Ork("Horak", extraLebenspunkte = 150)
var held3 = Dunkelelf("Anarwen", wenigerLeben = 250)
var beutel = Beutel()

var endboss = Endboss("MolagBal", 1000)
var miniboss = Miniboss("Seelen Leibeigener", wenigerLeben = 500)


var heldenListe = mutableListOf<Helden>(held1, held2, held3)
var randomHeld = heldenListe.random()
var lebtHeldNoch = true

fun lebenspunkteCheck(helden: Helden) { //noch nicht fertig
    if (helden.lebenspunkte <= 0)
        helden.lebenspunkte = 0
        helden.lebtHeldNoch = false
}





//Das hat Benni mir gezeigt :D
fun spacer(ammount: Int){
    repeat(ammount) {
        println()
    }
}



/** Hier könnte eine Beschreibung stehen
 * @return helden
 */
fun heldenMenue(gegner: Gegner): Any? {
    spacer(5)
    println("Wähle deinen Helden:")
    println("In Klammern stehen die aktuellen Lebenspunkte")
    println("1 ="+magenta+" Khajit (${held1.lebenspunkte})"+reset+" | 2 ="+magenta+" Ork (${held2.lebenspunkte})"+reset+" | 3 ="+magenta+" Dunkelelf (${held3.lebenspunkte})"+reset+" | 4 = Beutel")

    var userInput: Int
    userInput = try {
        readLine()?.toInt() ?: 0
    } catch (e: NumberFormatException) {
        0
    }

    return when (userInput) {
        1 -> {
            held1.battlemenueKhajit(gegner)

        }

        2 -> {
            held2.battlemenueOrk(gegner)

        }

        3 -> {
            held3.battlemenueDunkelelf(gegner)

        }
        4 -> {
            beutel.beutelInventar()

        }


        else -> {
            println("Ungültige Eingabe. Bitte wähle 1 - 4.")
            heldenMenue(gegner)
        }
    }
}

//Die Funktion wurde mithilfe von Chat Gpt erstellt
fun kampfRunde() {
    var counter: Int = 1
    while (!gameOver(endboss, held1, held2, held3)) {

        if (!minibossSpawnt && endboss.lebenspunkte <= endboss.maxLebenspunkte / 2) {
            minibossSpawnt = true
            println("Molag Bal ruft einen Seelen Leibeigenen herbei...")
            println("Molag Bal zieht sich zurück und lässt seinen Leibeignen kämpfen.")
            miniboss.minibossAttacke()

        }

        else if (endboss.lebenspunkte > 0) {

            println("...und wartet welcher Held sich ihm zuerst stellen wird...")
            println("")
            println(yellow+"-------------------  $counter Runde beginnt ---------------------"+reset)

            if (minibossSpawnt && miniboss.lebenspunkte > 0) {

                println("Der Seelenleibeigene sucht sich sein nächstes Opfer aus!")
                miniboss.minibossAttacke()
                heldenMenue(miniboss)
                heldenMenue(miniboss)
                heldenMenue(miniboss)



                held1.hatSchonAngegriffen = false
                held2.hatSchonAngegriffen = false
                held3.hatSchonAngegriffen = false
                beutel.wurdeBereitsBenutzt = false

            } else {

                heldenMenue(endboss)
                heldenMenue(endboss)
                heldenMenue(endboss)
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



