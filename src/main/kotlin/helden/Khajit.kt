package helden

import endboss.Endboss
import endboss.Gegner
import heldenMenue


class Khajit(name: String) : Helden(name) {
    var assassinenKlinge: Int = 200
    var schattenSchuss: Int = 150
    var verwirrungSchlag: Int = 100
    var mondsichelGranate: Int = 50

    var hatSchonAngegriffen: Boolean = false
    var lebtNoch: Boolean = true

    fun schattenSchuss(gegner: Gegner) {
        gegner.lebenspunkte -= schattenSchuss
        println("Der Khajit hat mit dem Schattenschuss ${gegner.name} $schattenSchuss Lebenspunkte Schaden zugefügt")
    }

    fun assassinenKlinge(gegner: Gegner) {
        gegner.lebenspunkte -= assassinenKlinge
        println("Nachtklinge der Khajit zückt seine Assassinenklinge und fügt ${gegner.name} $assassinenKlinge Lebenspunkte Schaden zu")
    }

    fun verwirrungsSchlag(gegner: Gegner) {
        gegner.lebenspunkte -= verwirrungSchlag
        println("Der Verwirrungsschlag trifft ${gegner.name} und fügt ihm Lebenspunkte Schaden zu")
    }

    fun mondsichelGranate(gegner: Gegner) {
        gegner.lebenspunkte -= mondsichelGranate
        println("Der Khajit wirft eine Mondsichelgranate und trifft damit ${gegner.name} und fügt ihm damit Lebenspunkte Schaden zu")
    }

    fun battlemenueKhajit(gegner: Gegner) {
        if (lebtNoch && !hatSchonAngegriffen) {
            println("Wähle nun deine Aktion aus")
            println("In den Klammern steht der Schaden, der Fähigkeit")
            println("1 = Assassinen Klinge (200) | 2 = Schattenschuss (150) | 3 = Verwirrungsschlag (100) | 4 = Mondsichelgranate (50) | 5 = Held wechseln | 6 = Abbrechen")

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
                    heldenMenue()?.let {
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
            println("Der Khajit kann in dieser Runde nicht mehr kämpfen!")
        }
    }
}
