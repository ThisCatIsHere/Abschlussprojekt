package helden

import endboss.Endboss
import endboss.Gegner

class Khajit(name: String) : Helden(name) {
    var assassinenKlinge: Int = 200
    var schattenSchuss: Int = 150
    var verwirrungSchlag: Int = 100
    var mondsichelGranate: Int = 50


    fun schattenSchuss(gegner: Gegner) {
        gegner.lebenspunkte -= schattenSchuss
        println("Der Khajit hat mit dem Schattenschuss dem ${gegner.name} $schattenSchuss Lebenspunkte Schaden zugefügt")
    }

    fun assassinenKlinge(gegner: Gegner) {
        gegner.lebenspunkte -= assassinenKlinge
        println("Hier kommt noch schönerer Text hin")
    }

    fun verwirrungsSchlag(gegner: Gegner) {
        gegner.lebenspunkte -= verwirrungSchlag
        println("Hier kommt noch ein passender Text hin")
    }

    fun mondsichelGranate(gegner: Gegner) {
        gegner.lebenspunkte -= mondsichelGranate
        println("Hier kommt noch ein passender Text hin")
    }

    fun battlemenueKhajit(gegner: Endboss) {
        println("Wähle nun deine Aktion aus")
        println("1 = Assassinen Klinge | 2 = Schattenschuss | 3 = Verwirrungsschlag | 4 = Mondsichelgranate | 5 = Abbrechen")

        var userInput: Int
        try {
            userInput = readLine()?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            userInput = 0
        }
        when (userInput) {
            1 -> {
                assassinenKlinge(gegner)
            }

            2 -> {
                schattenSchuss(gegner)
            }

            3 -> {
                verwirrungsSchlag(gegner)
            }

            4 -> {
                mondsichelGranate(gegner)
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