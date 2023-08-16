package helden

import cyan
import endboss.Gegner
import green
import heldenMenue

import red
import reset
import spacer
import yellow

//Ork muss noch geändert werden, da er Probleme bei der Seelenfluch Methode macht
class Ork(name: String, extraLebenspunkte: Int) : Helden(name, lebenspunkte = 750 + extraLebenspunkte, lebtHeldNoch = true) {

    var extraLebenspunkte = 150

    var blockade: Int = 300
    var versengenderSchlag: Int = 250
    var kettenDerVerwuestung: Int = 200
    var glutGranate: Int = 150

    var hatSchonAngegriffen: Boolean = false



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

    fun battlemenueOrk(gegner: Gegner) {
        spacer(5)
        var hatAktionAusgewaehlt = false
        while (!hatAktionAusgewaehlt) {
            if (lebtHeldNoch && !hatSchonAngegriffen) {
                println("Wähle nun deine Aktion aus")
                println("In den Klammern steht der Schaden, der Fähigkeit")
                println("1 =" + cyan + " Blockade (300)" + reset + " | 2 =" + cyan + " Versengender Schlag (250)" + reset + " | 3 =" + cyan + " Ketten der Verwüstung (200)" + reset + " | 4 =" + cyan + " Glutgranate (150)" + reset + " | 5 =" + yellow + " Held wechseln" + reset + " | 6 =" + red + " Abbrechen" + reset)

                var userInput: Int
                try {
                    userInput = readLine()?.toInt() ?: 0
                } catch (e: NumberFormatException) {
                    userInput = 0
                }
                when (userInput) {
                    1 -> {
                        blockade(gegner)
                        hatAktionAusgewaehlt = true
                    }

                    2 -> {
                        versengenderSchlag(gegner)
                        hatAktionAusgewaehlt = true
                    }

                    3 -> {
                        kettenDerVerwuestung(gegner)
                        hatAktionAusgewaehlt = true
                    }

                    4 -> {
                        glutGranate(gegner)
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
                println("\tDer Ork kann in dieser Runde nicht mehr kämpfen!")
                println("************************************************************"+reset)
                hatAktionAusgewaehlt = true
            }
        }
    }

}
