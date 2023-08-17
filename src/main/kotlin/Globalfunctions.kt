import Handwerksbeutel.Beutel
import endboss.Endboss
import endboss.Gegner
import endboss.Miniboss

import helden.Dunkelelf
import helden.Helden
import helden.Khajit
import helden.Ork

var minibossSpawnt = false

// Definition von Farbvariablen für die Konsolenausgabe
var red = "\u001B[31m"
var green = "\u001B[32m"
var yellow = "\u001B[33m"
var cyan = "\u001B[36m"
var magenta = "\u001B[35m"
var blue = "\u001B[34m"
var reset = "\u001B[0m"

// Definition von Helden und Gegnern
var held = Khajit("Nachtklinge")
var held2 = Ork("Horak", extraLebenspunkte = 150)
var held3 = Dunkelelf("Anarwen", wenigerLeben = 250)
var beutel = Beutel()

var endboss = Endboss("MolagBal", 900)
var miniboss = Miniboss("Seelen Leibeigener")

var heldenListe = mutableListOf<Helden>(held, held2, held3)

// Überprüfung der Lebenspunkte eines Helden und Setzen von "lebtHeldNoch" basierend auf den Lebenspunkten
fun lebenspunkteCheck(helden: Helden) {
    if (helden.lebenspunkte <= 0) {
        helden.lebenspunkte = 0
        helden.lebtHeldNoch = false
    }
}


//Das hat Benni mir gezeigt :D
// Funktion zum Einfügen von Leerräumen in der Konsolenausgabe
fun spacer(ammount: Int) {
    repeat(ammount) {
        println()
    }
}


/** Hier könnte eine Beschreibung stehen
 * @return helden
 */
// Menü zur Auswahl des Helden, der gegen einen Gegner kämpft
fun heldenMenue(gegner: Gegner): Any? {
    spacer(3)
    println("Wähle deinen Helden:")
    println("In Klammern stehen die aktuellen Lebenspunkte")
    if (held.lebtHeldNoch) {
        print("1 =$magenta Khajit (${held.lebenspunkte})$reset | ")
    }
    if (held2.lebtHeldNoch) {
        print("2 =$magenta Ork (${held2.lebenspunkte})$reset | ")
    }
    if (held3.lebtHeldNoch) {
        print("3 =$magenta Dunkelelf (${held3.lebenspunkte})$reset | ")
    }

    println("4 = Beutel")

    // Auswertung der Benutzereingabe, Rückgabe einer entsprechenden Aktion und Auffangen eines Fehlers
    var userInput: Int
    userInput = try {
        readLine()?.toInt() ?: 0
    } catch (e: NumberFormatException) {
        0
    }

    return when (userInput) {
        1 -> {
            held.battlemenueKhajit(gegner)

        }

        2 -> {
            held2.battlemenueOrk(gegner)

        }

        3 -> {
            held3.battlemenueDunkelelf(gegner)

        }

        4 -> {
            // Aufruf der Methode für das Inventar des Beutels
            beutel.beutelInventar()

        }


        else -> {
            println("Ungültige Eingabe. Bitte wähle 1 - 4.")
            heldenMenue(gegner)
        }
    }
}

//Die Funktion wurde mithilfe von Chat Gpt erstellt
// Die Funktion Kampfrunde läuft solange, bis das Spiel entweder durch Game Over oder Sieg beendet ist.
fun kampfRunde() {
    // Ein Zähler für die Rundennummerierung
    var counter: Int = 1

    // Die Schleife läuft, bis das Spiel beendet ist
    while (!gameOver(endboss, held, held2, held3)) {
        // Überprüfen und aktualisieren der Lebenspunkte aller Helden
        heldenListe.forEach { lebenspunkteCheck(it) }

        // Entfernen von Helden, die nicht mehr leben
        if (!held.lebtHeldNoch) {
            heldenListe.remove(held)
        }
        if (!held2.lebtHeldNoch) {
            heldenListe.remove(held2)
        }
        if (!held3.lebtHeldNoch) {
            heldenListe.remove(held3)
        }
        // Wenn der Endboss weniger als die Hälfte seiner maximalen Lebenspunkte hat und der Miniboss noch nicht aufgetaucht ist
        if (!minibossSpawnt && endboss.lebenspunkte <= endboss.maxLebenspunkte / 2) {
            minibossSpawnt = true
            println("Molag Bal ruft einen Seelen Leibeigenen herbei...")
            println("Molag Bal zieht sich zurück und lässt seinen Leibeignen kämpfen.")
            miniboss.minibossAttacke()

        }
        // Wenn der Endboss noch lebt
        else if (endboss.lebenspunkte > 0) {

            println("...und wartet welcher Held sich ihm zuerst stellen wird...")
            println("")
            println(yellow + "-------------------  $counter Runde beginnt ---------------------" + reset)
            println(yellow + "Noch verbleibende Lebenspunkte von Molag Bal: " + endboss.lebenspunkte + reset)

            // Wenn der Miniboss lebt
            if (minibossSpawnt && miniboss.lebenspunkte > 0) {

                println("Der Seelenleibeigene sucht sich sein nächstes Opfer aus!")
                miniboss.minibossAttacke()
                heldenListe.forEach { heldenMenue(miniboss) }
                println(yellow + "Noch verbleibende Lebenspunkte vom Seelenleibeigenen: " + miniboss.lebenspunkte + reset)

                // Zurücksetzen von Angriffsstatus und Zustand des Beutels
                held.hatSchonAngegriffen = false
                held2.hatSchonAngegriffen = false
                held3.hatSchonAngegriffen = false
                beutel.wurdeBereitsBenutzt = false

            } else {
                // Wenn der Endboss nicht mehr lebt
                for (held in heldenListe) {

                    heldenMenue(endboss)
                    if (endboss.lebenspunkte <= 0) {
                        break
                    }
                }

                println("..........................................................")
                endboss.endbossAttacke()
                held.hatSchonAngegriffen = false
                held2.hatSchonAngegriffen = false
                held3.hatSchonAngegriffen = false

            }

            println("")


        }
        // Erhöhen des Rundenzählers
        counter += 1
    }

    println("Das Spiel ist vorbei.")
}

fun gameOver(endboss: Endboss, held1: Khajit, held2: Ork, held3: Dunkelelf): Boolean {

    // Überprüfen, ob alle Helden keine Lebenspunkte mehr haben
    if ((held1.lebenspunkte <= 0) && (held2.lebenspunkte <= 0) && (held3.lebenspunkte <= 0)) {
        println(red + "-------------------------------------------------")
        println("- Game Over, Molag Bal hat Eure Helden besiegt! -")
        println("-------------------------------------------------" + reset)
        return true

        // Überprüfen, ob der Endboss keine Lebenspunkte mehr hat
    } else if (endboss.lebenspunkte <= 0) {
        println(cyan + "///////////////////////////////////////")
        println("/ Gewonnen! Du hast Molag Bal besiegt /")
        println("///////////////////////////////////////" + reset)
        return true

    }
    // Das Spiel ist noch nicht vorbei
    return false
}



