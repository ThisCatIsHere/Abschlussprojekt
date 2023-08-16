package helden

import cyan
import endboss.Endboss
import endboss.Gegner
import green

import heldenMenue
import red
import reset
import spacer
import yellow

//Eine neue Klasse namens Khajit, die von der Klasse "Helden" erbt.
class Khajit(name: String) : Helden(name, lebtHeldNoch = true) {

    //Eigenschaften (Fähigkeiten) für den Khajiten
    var assassinenKlinge: Int = 200
    var schattenSchuss: Int = 150
    var verwirrungSchlag: Int = 100
    var mondsichelGranate: Int = 50

    var hatSchonAngegriffen: Boolean = false


    //Hier folgen die Methoden vom Khajit Helden

    fun schattenSchuss(gegner: Gegner) {
        gegner.lebenspunkte -= schattenSchuss

        println(green + "------------------------------------------------------------------------------")
        println("Der Khajit hat mit dem Schattenschuss ${gegner.name} $schattenSchuss Schaden zugefügt")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun assassinenKlinge(gegner: Gegner) {
        gegner.lebenspunkte -= assassinenKlinge
        println(green + "------------------------------------------------------------------------------")
        println("Nachtklinge der Khajit zückt seine Assassinenklinge und fügt ${gegner.name} $assassinenKlinge Schaden zu")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun verwirrungsSchlag(gegner: Gegner) {
        gegner.lebenspunkte -= verwirrungSchlag
        println(green + "------------------------------------------------------------------------------")
        println("Der Verwirrungsschlag trifft ${gegner.name} und fügt ihm $verwirrungSchlag Schaden zu")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun mondsichelGranate(gegner: Gegner) {
        gegner.lebenspunkte -= mondsichelGranate
        println(green + "------------------------------------------------------------------------------")
        println("Der Khajit wirft eine Mondsichelgranate und trifft damit ${gegner.name} und fügt ihm damit $mondsichelGranate Schaden zu")
        println("------------------------------------------------------------------------------" + reset)
    }

    // Kampfmenü des Khajit
    fun battlemenueKhajit(gegner: Gegner) {
        spacer(6) // Führt die Funktion spacer() mit dem Parameter 6 aus, um Abstand zu erzeugen.
        var hatAktionAusgewaehlt = false // Initialisiert eine Variable, die angibt, ob eine Aktion ausgewählt wurde.

        // Eine Schleife, die solange läuft, bis eine Aktion ausgewählt wurde.
        while (!hatAktionAusgewaehlt) {
            if (lebtHeldNoch && !hatSchonAngegriffen) {
                // Wenn der Khajit-Held noch lebt und noch nicht angegriffen hat.
                println("Wähle nun deine Aktion aus")
                println("In den Klammern steht der Schaden, der Fähigkeit")
                // Menüoptionen anzeigen
                println("1 =" + cyan + " Assassinen Klinge (200)" + reset + " | 2 =" + cyan + " Schattenschuss (150)" + reset + " | 3 =" + cyan + " Verwirrungsschlag (100)" + reset + " | 4 =" + cyan + " Mondsichelgranate (50)" + reset + " | 5 =" + yellow + " Held wechseln" + reset + " | 6 =" + red + " Abbrechen" + reset)

                var userInput: Int
                try {
                    // Liest die Benutzereingabe und wandelt sie in eine Zahl um.
                    userInput = readLine()?.toInt() ?: 0
                } catch (e: NumberFormatException) {
                    userInput = 0
                }
                when (userInput) {
                    1 -> {
                        // Führt die Methode assassinenKlinge() aus.
                        assassinenKlinge(gegner)
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    2 -> {
                        // Führt die Methode schattenSchuss() aus.
                        schattenSchuss(gegner)
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    3 -> {
                        // Führt die Methode verwirrungsSchlag() aus.
                        verwirrungsSchlag(gegner)
                        // Die Schleife wird beendet.
                        hatAktionAusgewaehlt = true
                    }

                    4 -> {
                        // Führt die Methode mondsichelGranate() aus.
                        mondsichelGranate(gegner)
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
                // Wenn der Khajit-Held nicht mehr kämpfen kann.
                println(yellow+"************************************************************")
                println("\tDer Khajit kann in dieser Runde nicht mehr kämpfen!")
                println("************************************************************"+reset)
                // Die Schleife wird beendet.
                hatAktionAusgewaehlt = true
            }
        }
    }


}
