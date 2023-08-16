package Handwerksbeutel

import cyan
import held
import held2
import held3
import red
import reset

class Vitaminbombe(name: String, wert: Int) : Item(name, wert) {
    var vitaminProzent: Double = 1.1

    fun vitaminbombe() {
        println(
            "Welcher Held soll geheilt werden?" +
                    ("1 =" + cyan + " Khajit (${held.lebenspunkte})" + reset + " | 2 =" + cyan + " Ork (${held2.lebenspunkte})" + reset + " " +
                            "| 3 =" + cyan + " Dunkelelf (${held3.lebenspunkte})" + reset + " | 4 = " + red + "Abbrechen" + reset)

        )
        var userInput: Int
        try {
            userInput = readLine()?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            userInput = 0
        }
        when (userInput) {
            1 -> {
                held.lebenspunkte = (held.lebenspunkte * 1.1).toInt()
                println("Der Khajit \"Nachtschatten\" wurde gestärkt!")
            }

            2 -> {
                held2.lebenspunkte = (held2.lebenspunkte * 1.1).toInt()
                println("Der Ork \"Horak\" wurde gestärkt!")
            }

            3 -> {
                held3.lebenspunkte = (held3.lebenspunkte * 1.1).toInt()
                println("Der Dunkelelf \"Anarwen\" wurde gestärkt!")
            }

        }

    }


}
