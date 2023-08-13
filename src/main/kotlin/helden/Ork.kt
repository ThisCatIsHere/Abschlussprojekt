package helden

import endboss.Endboss
import endboss.Gegner
//Ork muss noch geändert werden, da er Probleme bei der Seelenfluch Methode macht
class Ork(name: String, extraLebenspunkte: Int) : Helden(name, lebenspunkte = 750 + extraLebenspunkte) {

    var extraLebenspunkte = 150

    var blockade: Int = 300
    var versengenderSchlag: Int = 250
    var kettenDerVerwuestung: Int = 200
    var glutGranate: Int = 150


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

    fun battlemenueOrk(gegner: Endboss) {
        println("Wähle nun deine Aktion aus")
        println("1 = Blockade | 2 = Versengender Schlag | 3 = Ketten der Verwüstung | 4 = Glutgranate | 5 = Abbrechen")

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
                println("Du hast die Aktion abgebrochen")
                //Laufzeitvariable einbauen
            }

            else -> {
                println("Du kannst nur die Zahlen 1 - 5 nutzen!")
            }
        }
    }
}
