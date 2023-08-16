package Handwerksbeutel

import endboss.Gegner
import helden.Helden
import reset
import yellow

open class Beutel() {

    var inventar: MutableList<Item> = mutableListOf()

    var nochVorhanden: Boolean = true
    var wurdeBereitsBenutzt: Boolean = false

    init {
        repeat(3) {
            var heiltrank = Heiltrank("Heiltrank", 50)
            inventar.add(heiltrank)
        }
        var vitaminbombe = Vitaminbombe("Vitaminbombe", 10)
        inventar.add(vitaminbombe)
    }

    fun addItem(item: Item) {
        inventar.add(item)
    }

    fun getItem(): List<Item> {
        return inventar.toMutableList()

    }

    fun beutelInventar() {
        if (nochVorhanden && !wurdeBereitsBenutzt) {
            println("Wähle nun deine Aktion aus")
            println("In den Klammern stehen die Werte der Heilung/Stärkung.")
            println("1 = Heiltrank1 (50%) | 2 = Heiltrank2 (50%) | 3 = Heiltrank3 (50%) | 4 = Vitaminbombe (10%) | 5 = Zurück zum Heldenmenü | 6 = Abbrechen")

            var userInput: Int
            try {
                userInput = readLine()?.toInt() ?: 0
            } catch (e: NumberFormatException) {
                userInput = 0
            }
            when (userInput) {
                1 -> {
                    var heiltrank = Heiltrank("Heiltrank", 50)
                    heiltrank.heilung()
                    inventar.remove(heiltrank)
                }

                2 -> {
                    var heiltrank = Heiltrank("Heiltrank", 50)
                    heiltrank.heilung()
                    inventar.remove(heiltrank)
                }

                3 -> {
                    var heiltrank = Heiltrank("Heiltrank", 50)
                    heiltrank.heilung()
                    inventar.remove(heiltrank)
                }

                4 -> {

                    //vitaminbombe(helden)
                }


            5 -> {
                println("Du hast die Aktion abgebrochen")
            }

            else -> {
                println("Du kannst nur die Zahlen 1 - 5 nutzen!")
            }
        }
        wurdeBereitsBenutzt = true

    } else
    {
        println(yellow+"Der Beutel wurde in dieser Runde bereits benutzt!"+reset)
    }
}
}
