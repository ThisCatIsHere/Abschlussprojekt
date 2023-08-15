package helden

import endboss.Gegner
import held1
import held2
import held3
import heldenMenue


// Name der Klasse (Eigenschaften der Klasse): Name der vererbten Klassen (vererbte Eigenschaften)
class Dunkelelf(name: String, wenigerLeben: Int) : Helden(name, lebenspunkte = 750 - wenigerLeben) {
    var wenigerLeben: Int = 250

    var sonnenFinsternis: Int = 200
    var blutMagie: Int = 150
    var sonnenZerstoerungsstab: Int = 100
    var heilung: Int = 10 //um 10% Leben erhöhen

    var hatSchonAngegriffen: Boolean = false
    var lebtNoch: Boolean = true


    fun sonnenFinsternis(gegner: Gegner) {
        gegner.lebenspunkte -= sonnenFinsternis
        println("Anarwen trifft mit seiner Sonnenfinsternis ${gegner.name} und fügt ihm ${sonnenFinsternis}Lebenspunkte Schaden zu")
    }

    fun blutMagie(gegner: Gegner) {
        gegner.lebenspunkte -= blutMagie
        println("Der Dunkelelf flüstert leise seinen Blutmagie Fluch und trifft ${gegner.name} und fügt ihm $blutMagie Lebenspunkte Schaden zu")
    }

    fun sonnenZerstoerungsstab(gegner: Gegner) {
        gegner.lebenspunkte -= sonnenZerstoerungsstab
        println("Anarwen schwingt seinen Sonnen Zerstörungsstab und trifft ${gegner.name} und fügt ihm $sonnenZerstoerungsstab Lebenspunkte Schaden zu")
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

            println("Die Helden wurden um 10% geheilt")
        } else {
            println("Es konnte niemand geheilt werden, da alle Helden noch ausreichend Leben haben")
        }
    }

    fun battlemenueDunkelelf(gegner: Gegner) {
        if (lebtNoch && !hatSchonAngegriffen) {
            println("Wähle nun deine Aktion aus")
            println("In den Klammern steht der Schaden, der Fähigkeit")
            println("1 = Sonnen Finsternis (200) | 2 = Blutmagie (150)| 3 = Sonnen Zerstörungsstab (100) | 4 = Heilung (+10%) | 5 = Held wechseln | 6 = Abbrechen")

            var userInput: Int
            try {
                userInput = readLine()?.toInt() ?: 0
            } catch (e: NumberFormatException) {
                userInput = 0
            }
            when (userInput) {
                1 -> {
                    sonnenFinsternis(gegner)
                }

                2 -> {
                    blutMagie(gegner)
                }

                3 -> {
                    sonnenZerstoerungsstab(gegner)
                }

                4 -> {
                    heilung(held1, held2, held3)
                }

                5 -> {
                    heldenMenue(gegner)?.let {
                        println("Held wechseln")
                    }
                }

                6 -> {
                    println("Du hast die Aktion abgebrochen")
                }

                else -> {
                    println("Du kannst nur die Zahlen 1 - 6 nutzen!")
                }
            }
            hatSchonAngegriffen = true
        } else {
            println("Der Dunkelelf kann in dieser Runde nicht mehr kämpfen!")
        }
    }
}




