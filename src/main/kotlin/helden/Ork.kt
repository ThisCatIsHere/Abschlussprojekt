package helden

import endboss.Gegner
import heldenMenue

//Ork muss noch geändert werden, da er Probleme bei der Seelenfluch Methode macht
class Ork(name: String, extraLebenspunkte: Int) : Helden(name, lebenspunkte = 750 + extraLebenspunkte) {

    var extraLebenspunkte = 150

    var blockade: Int = 300
    var versengenderSchlag: Int = 250
    var kettenDerVerwuestung: Int = 200
    var glutGranate: Int = 150

    var hatSchonAngegriffen: Boolean = false
    var lebtNoch: Boolean = true


    fun blockade(gegner: Gegner) {
        lebenspunkte -= (gegner.angriffskraft - blockade)
        println("Horak stellt seine Blockade, welche ${gegner.name} trifft und $blockade Lebenspunkte Schaden hinzufügt")
    }

    fun versengenderSchlag(gegner: Gegner) {
        gegner.lebenspunkte -= versengenderSchlag
        println("Horak holt mit seiner glühenden Axt aus, und trifft ${gegner.name} mit seinem $versengenderSchlag")
    }

    fun kettenDerVerwuestung(gegner: Gegner) {
        gegner.lebenspunkte -= kettenDerVerwuestung
        println("Der Ork wirft seine Ketten der Verwüstung und trifft ${gegner.name}")
    }

    fun glutGranate(gegner: Gegner) {
        gegner.lebenspunkte -= glutGranate
        println("Horak lässt seine Glutgranate zum Gegner kullern und trifft ${gegner.name}")
    }

    fun battlemenueOrk(gegner: Gegner) {
        if (lebtNoch && !hatSchonAngegriffen) {
            println("Wähle nun deine Aktion aus")
            println("In den Klammern steht der Schaden, der Fähigkeit")
            println("1 = Blockade (300) | 2 = Versengender Schlag (250)| 3 = Ketten der Verwüstung (200) | 4 = Glutgranate (150)| 5 = Abbrechen")

            var userInput: Int
            try {
                userInput = readLine()?.toInt() ?: 0
            } catch (e: NumberFormatException) {
                userInput = 0
            }
            when (userInput) {
                1 -> {
                    blockade(gegner)
                }

                2 -> {
                    versengenderSchlag(gegner)
                }

                3 -> {
                    kettenDerVerwuestung(gegner)
                }

                4 -> {
                    glutGranate(gegner)
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
            println("Der Ork kann in dieser Runde nicht mehr kämpfen!")
        }
    }
}
