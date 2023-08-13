package helden

import endboss.Endboss
import endboss.Gegner
import held1
import held2
import held3

// Name der Klasse (Eigenschaften der Klasse): Name der vererbten Klassen (vererbte Eigenschaften)
class Dunkelelf(name: String, wenigerLeben: Int) : Helden(name, lebenspunkte = 750 - wenigerLeben) {
    var wenigerLeben: Int = 250
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

    fun heilung(helden1: Helden, helden2: Helden, helden3: Helden) {
        // hier sollte noch geprüft werden ob die Helden Überhaupt Leben verloren haben
        // Wenn ja dann darf heilung erfolgen
        // Wenn nein dann muss eine Meldung kommen dieser Skill konnte nicht ausgeführt werden oder so ähnlich

        helden1.lebenspunkte = (helden1.lebenspunkte * 1.1).toInt() //+ 10% Heilung
        helden2.lebenspunkte = (helden2.lebenspunkte * 1.1).toInt() //+ 10% Heilung
        helden3.lebenspunkte = (helden3.lebenspunkte * 1.1).toInt() //+ 10% Heilung
        println("Die Helden wurden um 10% geheilt")
        /*println(helden1.lebenspunkte)
        println(helden2.lebenspunkte)
        println(helden3.lebenspunkte)
        Hier noch eine schönere Println
         */
    }

    fun battlemenueDunkelelf(gegner: Endboss) {
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
                println("Du hast die Aktion abgebrochen")
                //Laufzeitvariable einbauen
            }

            else -> {
                println("Du kannst nur die Zahlen 1 - 5 nutzen!")
            }
        }
    }
}