package helden

import cyan
import endboss.Gegner
import green
import held
import held2
import held3
import heldenMenue
import red
import reset
import spacer
import yellow


// Name der Klasse (Eigenschaften der Klasse): Name der vererbten Klassen (vererbte Eigenschaften)
class Dunkelelf(name: String, wenigerLeben: Int) : Helden(name, lebenspunkte = 750 - wenigerLeben, lebtHeldNoch = true) {
    var wenigerLeben: Int = 250

    var sonnenFinsternis: Int = 200
    var blutMagie: Int = 150
    var sonnenZerstoerungsstab: Int = 100
    var heilung: Int = 10 //um 10% Leben erhöhen

    var hatSchonAngegriffen: Boolean = false
    var lebtNoch: Boolean = true


    fun sonnenFinsternis(gegner: Gegner) {
        gegner.lebenspunkte -= sonnenFinsternis
        println(green + "------------------------------------------------------------------------------")
        println("Anarwen trifft mit seiner Sonnenfinsternis ${gegner.name} und fügt ihm ${sonnenFinsternis}Lebenspunkte Schaden zu")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun blutMagie(gegner: Gegner) {
        gegner.lebenspunkte -= blutMagie
        println(green + "------------------------------------------------------------------------------")
        println("Der Dunkelelf flüstert leise seinen Blutmagie Fluch und trifft ${gegner.name} und fügt ihm $blutMagie Lebenspunkte Schaden zu")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun sonnenZerstoerungsstab(gegner: Gegner) {
        gegner.lebenspunkte -= sonnenZerstoerungsstab
        println(green + "------------------------------------------------------------------------------")
        println("Anarwen schwingt seinen Sonnen Zerstörungsstab und trifft ${gegner.name} und fügt ihm $sonnenZerstoerungsstab Lebenspunkte Schaden zu")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun heilung(helden1: Helden, helden2: Helden, helden3: Helden) {
        var minLostLP: Int = 10

        if (helden1.verloreneLebenspunkte() >= minLostLP ||
            helden2.verloreneLebenspunkte() >= minLostLP ||
            helden3.verloreneLebenspunkte() >= minLostLP
        ) {

            helden1.lebenspunkte = (helden1.lebenspunkte * 1.1).toInt() //+ 10% Heilung
            helden2.lebenspunkte = (helden2.lebenspunkte * 1.1).toInt() //+ 10% Heilung
            helden3.lebenspunkte = (helden3.lebenspunkte * 1.1).toInt() //+ 10% Heilung

            println(green + "------------------------------------------------------------------------------")
            println("Die Helden wurden um 10% geheilt")
            println("------------------------------------------------------------------------------" + reset)
        } else {
            println(yellow+"Es konnte niemand geheilt werden, da alle Helden noch ausreichend Leben haben"+reset)
        }
    }

    fun battlemenueDunkelelf(gegner: Gegner) {
        spacer(5)
        var hatAktionAusgewaehlt = false
        while (!hatAktionAusgewaehlt) {
            if (lebtHeldNoch && !hatSchonAngegriffen) {
                println("Wähle nun deine Aktion aus")
                println("In den Klammern steht der Schaden, der Fähigkeit")
                println("1 =" + cyan + " Sonnen Finsternis (200)" + reset + " | 2 =" + cyan + " Blutmagie (150)" + reset + " | 3 =" + cyan + " Sonnen Zerstörungsstab (100)" + reset + " | 4 =" + cyan + " Heilung (+10%)" + reset + " | 5 =" + yellow + " Held wechseln" + reset + " | 6 =" + red + " Abbrechen" + reset)

                var userInput: Int
                try {
                    userInput = readLine()?.toInt() ?: 0
                } catch (e: NumberFormatException) {
                    userInput = 0
                }
                when (userInput) {
                    1 -> {
                        sonnenFinsternis(gegner)
                        hatAktionAusgewaehlt = true
                    }

                    2 -> {
                        blutMagie(gegner)
                        hatAktionAusgewaehlt = true
                    }

                    3 -> {
                        sonnenZerstoerungsstab(gegner)
                        hatAktionAusgewaehlt = true
                    }

                    4 -> {
                        heilung(held, held2, held3)
                        hatAktionAusgewaehlt = true
                    }

                    5 -> {
                        heldenMenue(gegner)
                        println("Held wechseln")
                        hatAktionAusgewaehlt = true
                    }

                    6 -> {
                        println("Du hast die Aktion abgebrochen")
                        hatAktionAusgewaehlt = true
                    }

                    else -> {
                        println("Du kannst nur die Zahlen 1 - 6 nutzen!")
                    }
                }
                hatSchonAngegriffen = true

            } else {
                println(yellow+"************************************************************")
                println("\tDer Dunkelelf kann in dieser Runde nicht mehr kämpfen!")
                println("************************************************************"+reset)
                hatAktionAusgewaehlt = true
            }
        }
    }

}




