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


//Eine neue Klasse namens Dunkelelf, die von der Klasse "Helden" erbt.
class Dunkelelf(name: String, wenigerLeben: Int) : Helden(name, lebenspunkte = 750 - wenigerLeben, lebtHeldNoch = true) {
    var wenigerLeben: Int = 250

    //Eigenschaften (Fähigkeiten) für den Dunkelelf
    var sonnenFinsternis: Int = 200
    var blutMagie: Int = 150
    var sonnenZerstoerungsstab: Int = 100
    var heilung: Int = 10 //um 10% Leben erhöhen

    //Diese Variable steht am Anfang auf false und wird später auf True gesetzt, wenn der Held bereits gekämpft hat, in der Runde
    var hatSchonAngegriffen: Boolean = false
    var lebtNoch: Boolean = true


    //Hier folgen die Methoden vom Dunkelelf Helden
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

        //Durch die If Abfrage wird sicher gestellt, das erst eine Heilung stattfindet, wenn auch Lebenspunkte verloren wurde.
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

    //Kampfmenü vom Dunkelelf
    fun battlemenueDunkelelf(gegner: Gegner) {
        // Führt die Funktion spacer() mit dem Parameter 5 aus, um Abstand zu erzeugen.
        spacer(5)

        // Initialisiert eine Variable, die angibt, ob eine Aktion ausgewählt wurde.
        var hatAktionAusgewaehlt = false

        // Eine Schleife, die solange läuft, bis eine Aktion ausgewählt wurde.
        while (!hatAktionAusgewaehlt) {
            if (lebtHeldNoch && !hatSchonAngegriffen) {
                // Wenn der Dunkelelf-Held noch lebt und noch nicht angegriffen hat.
                println("Wähle nun deine Aktion aus")
                println("In den Klammern steht der Schaden, der Fähigkeit")
                // Menüoptionen anzeigen
                println("1 =" + cyan + " Sonnen Finsternis (200)" + reset + " | 2 =" + cyan + " Blutmagie (150)" + reset + " | 3 =" + cyan + " Sonnen Zerstörungsstab (100)" + reset + " | 4 =" + cyan + " Heilung (+10%)" + reset + " | 5 =" + yellow + " Held wechseln" + reset + " | 6 =" + red + " Abbrechen" + reset)

                var userInput: Int
                try {
                    // Liest die Benutzereingabe und wandelt sie in eine Zahl um.
                    userInput = readLine()?.toInt() ?: 0
                } catch (e: NumberFormatException) {
                    userInput = 0
                }
                when (userInput) {
                    1 -> {
                        // Führt die Methode sonnenFinsternis() aus.
                        sonnenFinsternis(gegner)
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    2 -> {
                        // Führt die Methode blutMagie() aus.
                        blutMagie(gegner)
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    3 -> {
                        // Führt die Methode sonnenZerstoerungsstab() aus.
                        sonnenZerstoerungsstab(gegner)
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    4 -> {
                        // Führt die Methode heilung() mit Heldenparametern aus.
                        heilung(held, held2, held3)
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
                        // Die Schleife wird beendet.
                        println("Du hast die Aktion abgebrochen")
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
                // Wenn der Dunkelelf-Held nicht mehr kämpfen kann.
                println(yellow+"************************************************************")
                println("\tDer Dunkelelf kann in dieser Runde nicht mehr kämpfen!")
                println("************************************************************"+reset)
                // Die Schleife wird beendet.
                hatAktionAusgewaehlt = true
            }
        }
    }


}




