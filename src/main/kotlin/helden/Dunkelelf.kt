package helden

import gegner.Endboss
import gegner.Gegner

// Name der Klasse (Eigenschaften der Klasse): Name der vererbten Klassen (vererbte Eigenschaften)
class Dunkelelf(name: String) : Helden(name) {
    var sonnenFinsternis: Int = 200
    var blutMagie: Int = 150
    var sonnenZerstoerungsstab: Int = 100
    var heilung: Int = 10 //um 10% Leben erhöhen


    fun sonnenFinsternis(gegner: Gegner) {
        gegner.lebenspunkte -= sonnenFinsternis
        println("Text")
    }

    fun blutMagie(gegner: Gegner) {
        gegner.lebenspunkte -= blutMagie
        println("Text")
    }

    fun sonnenZerstoerungsstab(gegner: Gegner) {
        gegner.lebenspunkte -= sonnenZerstoerungsstab
        println("Text")
    }

    fun heilung(helden: Endboss) {
        helden.lebenspunkte + heilung
        println("Die Helden wurden um 10% geheilt")
    }

    fun battlemenueDunkelelf(helden: Dunkelelf, gegner: Endboss) {
        println("Wähle nun deine Aktion aus")
        println("1 = Sonnen Finsternis | 2 = Blutmagie | 3 = Sonnen Zerstörungsstab | 4 = Heilung | 5 = Abbrechen")

        var userInput: Int
        try {
            userInput = readLine()?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            userInput = 0
        }
        when (userInput) {
            1 -> {
                helden.sonnenFinsternis(gegner)
            }

            2 -> {
                helden.blutMagie(gegner)
            }

            3 -> {
                helden.sonnenZerstoerungsstab(gegner)
            }

            4 -> {
                helden.heilung(gegner)
            }

            5 -> {
                println("Du hast die Aktion abgebrochen")
                //Laufzeitvariable einbauen
            }

            else -> {
                println("Du kannst nur die Zahlen 1 - 5 nutzen!")
            }
        }
    }
}