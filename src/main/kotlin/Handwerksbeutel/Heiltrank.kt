package Handwerksbeutel

import blue
import cyan
import held
import held2
import held3
import red
import reset

//Neue Klasse "Heiltrank", welche von der Klasse "Item" erbt.
class Heiltrank(name: String, wert: Int) : Item(name, wert) {
    var heilung: Double = 0.5

    fun heilung() {
        // Ausgabe einer Benutzerabfrage für die Auswahl eines Helden zur Heilung
        println(
            "Welcher Held soll geheilt werden?" +
                    ("1 =" + cyan + " Khajit (${held.lebenspunkte})" + reset + " | 2 =" + cyan + " Ork (${held2.lebenspunkte})" + reset + " " +
                            "| 3 =" + cyan + " Dunkelelf (${held3.lebenspunkte})" + reset + " | 4 = " + red + "Abbrechen" + reset)

        )
        // Hier wird die Benutzereingabe eingelesen, in Int um gewandelt und potenzielle Fehler abgefangen
        var userInput : Int
                try {
                    userInput = readLine()?.toInt() ?: 0
                } catch (e: NumberFormatException) {
                    userInput = 0
                }
        // Hier wird gefragt, welcher Held geheilt werden soll
        when (userInput) {
            1 -> {
                held.lebenspunkte = (held.lebenspunkte * 1.5).toInt()
                println(blue+"++++++++++++++++++++++++++++++++++++++++++++++++")
                println("+++ Der Khajit \"Nachtschatten\" wurde geheilt! +++")
                println("++++++++++++++++++++++++++++++++++++++++++++++++"+reset)
            }

            2 -> {
                held2.lebenspunkte = (held2.lebenspunkte * 1.5).toInt()
                println(blue+"++++++++++++++++++++++++++++++++++++++++++++++++")
                println("+++ Der Ork \"Horak\" wurde geheilt! +++")
                println("++++++++++++++++++++++++++++++++++++++++++++++++"+reset)
            }

            3 -> {
                held3.lebenspunkte = (held3.lebenspunkte * 1.5).toInt()
                println(blue+"++++++++++++++++++++++++++++++++++++++++++++++++")
                println("+++ Der Dunkelelf \"Anarwen\" wurde geheilt! +++")
                println("++++++++++++++++++++++++++++++++++++++++++++++++"+reset)
            }

        }

    }
}