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


class Khajit(name: String) : Helden(name, lebtHeldNoch = true) {

    var assassinenKlinge: Int = 200
    var schattenSchuss: Int = 150
    var verwirrungSchlag: Int = 100
    var mondsichelGranate: Int = 50

    var hatSchonAngegriffen: Boolean = false

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

    fun battlemenueKhajit(gegner: Gegner) {
        spacer(6)
        var hatAktionAusgewaehlt = false
        while (!hatAktionAusgewaehlt) {
            if (lebtHeldNoch && !hatSchonAngegriffen) {
                println("Wähle nun deine Aktion aus")
                println("In den Klammern steht der Schaden, der Fähigkeit")
                println("1 =" + cyan + " Assassinen Klinge (200)" + reset + " | 2 =" + cyan + " Schattenschuss (150)" + reset + " | 3 =" + cyan + " Verwirrungsschlag (100)" + reset + " | 4 =" + cyan + " Mondsichelgranate (50)" + reset + " | 5 =" + yellow + " Held wechseln" + reset + " | 6 =" + red + " Abbrechen" + reset)

                var userInput: Int

                try {
                    userInput = readLine()?.toInt() ?: 0
                } catch (e: NumberFormatException) {
                    userInput = 0
                }
                when (userInput) {
                    1 -> {
                        assassinenKlinge(gegner)
                        hatAktionAusgewaehlt = true
                    }

                    2 -> {
                        schattenSchuss(gegner)
                        hatAktionAusgewaehlt = true
                    }

                    3 -> {
                        verwirrungsSchlag(gegner)
                        hatAktionAusgewaehlt = true
                    }

                    4 -> {
                        mondsichelGranate(gegner)
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
                println("\tDer Khajit kann in dieser Runde nicht mehr kämpfen!")
                println("************************************************************"+reset)
                hatAktionAusgewaehlt = true
            }
        }
    }

}
