package Handwerksbeutel

import cyan
import held1
import held2
import held3
import red
import reset

class Heiltrank(name: String, wert: Int) : Item(name, wert) {
    var heilung: Double = 0.5

    fun heilung() {
        println(
            "Welcher Held soll geheilt werden?" +
                    ("1 =" + cyan + " Khajit (${held1.lebenspunkte})" + reset + " | 2 =" + cyan + " Ork (${held2.lebenspunkte})" + reset + " " +
                            "| 3 =" + cyan + " Dunkelelf (${held3.lebenspunkte})" + reset + " | 4 = " + red + "Abbrechen" + reset)

        )
        var userInput : Int
                try {
                    userInput = readLine()?.toInt() ?: 0
                } catch (e: NumberFormatException) {
                    userInput = 0
                }
        when (userInput) {
            1 -> {
                held1.lebenspunkte = (held1.lebenspunkte * 1.5).toInt()
                println("Der Khajit \"Nachtschatten\" wurde geheilt!")
            }

            2 -> {
                held2.lebenspunkte = (held2.lebenspunkte * 1.5).toInt()
                println("Der Ork \"Horak\" wurde geheilt!")
            }

            3 -> {
                held3.lebenspunkte = (held3.lebenspunkte * 1.5).toInt()
                println("Der Dunkelelf \"Anarwen\" wurde geheilt!")
            }

        }

    }
}