package helden

import cyan
import endboss.Gegner
import green
import heldenMenue

import red
import reset
import spacer
import yellow

//Eine neue Klasse namens Ork, die von der Klasse "Helden" erbt.
class Ork(name: String, extraLebenspunkte: Int) : Helden(name, lebenspunkte = 750 + extraLebenspunkte, lebtHeldNoch = true) {

    //Eigenschaften (Fähigkeiten) für den Ork
    var extraLebenspunkte = 150

    var blockade: Int = 300
    var versengenderSchlag: Int = 250
    var kettenDerVerwuestung: Int = 200
    var glutGranate: Int = 150

    var hatSchonAngegriffen: Boolean = false


    //Hier folgen die Methoden vom Ork Helden
    fun blockade(gegner: Gegner) {
        gegner.lebenspunkte -= blockade
        println(green + "------------------------------------------------------------------------------")
        println("Horak stellt seine Blockade, welche ${gegner.name} trifft und $blockade Lebenspunkte Schaden hinzufügt")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun versengenderSchlag(gegner: Gegner) {
        gegner.lebenspunkte -= versengenderSchlag
        println(green + "------------------------------------------------------------------------------")
        println("Horak holt mit seiner glühenden Axt aus, und trifft ${gegner.name} mit seinem $versengenderSchlag")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun kettenDerVerwuestung(gegner: Gegner) {
        gegner.lebenspunkte -= kettenDerVerwuestung
        println(green + "------------------------------------------------------------------------------")
        println("Der Ork wirft seine Ketten der Verwüstung und trifft ${gegner.name}")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun glutGranate(gegner: Gegner) {
        gegner.lebenspunkte -= glutGranate
        println(green + "------------------------------------------------------------------------------")
        println("Horak lässt seine Glutgranate zum Gegner kullern und trifft ${gegner.name}")
        println("------------------------------------------------------------------------------" + reset)
    }

    // Kampfmenü des Orks
    fun battlemenueOrk(gegner: Gegner) {
        // Führt die Funktion spacer() mit dem Parameter 5 aus, um Abstand zu erzeugen.
        spacer(5)
        // Initialisiert eine Variable, die angibt, ob eine Aktion ausgewählt wurde.
        var hatAktionAusgewaehlt = false

        // Eine Schleife, die solange läuft, bis eine Aktion ausgewählt wurde.
        while (!hatAktionAusgewaehlt) {
            if (lebtHeldNoch && !hatSchonAngegriffen) {
                // Wenn der Ork-Held noch lebt und noch nicht angegriffen hat.
                println("Wähle nun deine Aktion aus")
                println("In den Klammern steht der Schaden, der Fähigkeit")
                // Menüoptionen anzeigen
                println("1 =" + cyan + " Blockade (300)" + reset + " | 2 =" + cyan + " Versengender Schlag (250)" + reset + " | 3 =" + cyan + " Ketten der Verwüstung (200)" + reset + " | 4 =" + cyan + " Glutgranate (150)" + reset + " | 5 =" + yellow + " Held wechseln" + reset + " | 6 =" + red + " Abbrechen" + reset)

                var userInput: Int
                try {
                    // Liest die Benutzereingabe und wandelt sie in eine Zahl um.
                    userInput = readLine()?.toInt() ?: 0
                } catch (e: NumberFormatException) {
                    userInput = 0
                }
                when (userInput) {
                    1 -> {
                        // Führt die Methode blockade() aus.
                        blockade(gegner)
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    2 -> {
                        // Führt die Methode versengenderSchlag() aus.
                        versengenderSchlag(gegner)
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    3 -> {
                        // Führt die Methode kettenDerVerwuestung() aus.
                        kettenDerVerwuestung(gegner)
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    4 -> {
                        // Führt die Methode glutGranate() aus.
                        glutGranate(gegner)
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    5 -> {
                        // Führt die Methode heldenMenue() aus.
                        heldenMenue(gegner)
                        println("Held wechseln")
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    6 -> {
                        println("Du hast die Aktion abgebrochen")
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    else -> {
                        // Eine Meldung für ungültige Eingaben.
                        println("Du kannst nur die Zahlen 1 - 6 nutzen!")
                    }
                }
                // Setzt hatSchonAngegriffen auf true, da der Held bereits angegriffen hat.
                hatSchonAngegriffen = true

            } else {
                // Wenn der Ork-Held nicht mehr kämpfen kann.
                println(yellow+"************************************************************")
                println("\tDer Ork kann in dieser Runde nicht mehr kämpfen!")
                println("************************************************************"+reset)
                // Die Schleife wird beendet.
                hatAktionAusgewaehlt = true
            }
        }
    }


}
