package endboss

import green
import held1
import held2
import held3
import helden.Helden
import heldenListe
import lebenspunkteCheck
import minibossSpawnt
import randomHeld
import red
import reset
import yellow


class Endboss(name: String, lebenspunkte: Int) : Gegner(name, lebenspunkte) {
    var maxLebenspunkte: Int = 900
    var seelenRaub: Int = 300 //soll alle helden treffen
    var seelenAnker: Int = 250
    var seelenFluch: Int = 100 //soll nur einen helden treffen,//10% pro Held, pro runde bis HP weniger als 20%
    var seelenZange: Int = 50
    var wuetendesSchnauben: Int = 25
    var verloreneSeele: Miniboss? = null //erst wenn der Endboss nur noch 50% leben hat


    /*Ich hatte die Methode so wie unten zuerst und habe dann gemerkt, dass ich die
      Lebenspunkte der Helden vergessen hatte und habe da nochmal Chat GPT gefragt.*/
    fun seelenRaubausfuehren(held1: Helden, held2: Helden, held3: Helden) {
        if (held1.lebtHeldNoch) {
            held1.lebenspunkte -= seelenRaub
            lebenspunkteCheck(held1)
            println(red + "------------------------------------------------------------------------------")
            println("${held1.name} wurde vom Seelenraub getroffen und hat nun ${held1.lebenspunkte} Lebenspunkte.")
            println("------------------------------------------------------------------------------" + reset)
        } else {
            println(yellow+"${held1.name} ist bereits besiegt und kann nicht angegriffen werden."+reset)
        }

        if (held2.lebtHeldNoch) {
            held2.lebenspunkte -= seelenRaub
            lebenspunkteCheck(held2)
            println(red + "------------------------------------------------------------------------------")
            println("${held2.name} wurde vom Seelenraub getroffen und hat nun ${held2.lebenspunkte} Lebenspunkte.")
            println("------------------------------------------------------------------------------" + reset)
        } else {
            println(yellow+"${held2.name} ist bereits besiegt und kann nicht angegriffen werden."+reset)
        }

        if (held3.lebtHeldNoch) {
            held3.lebenspunkte -= seelenRaub
            lebenspunkteCheck(held3)
            println(red + "------------------------------------------------------------------------------")
            println("${held3.name} wurde vom Seelenraub getroffen und hat nun ${held3.lebenspunkte} Lebenspunkte.")
            println("------------------------------------------------------------------------------" + reset)
        } else {
            println(yellow+"${held3.name} ist bereits besiegt und kann nicht angegriffen werden."+reset)
        }

        // 2 Version:
        /*held1.lebenspunkteCheck(held1)
        held2.lebenspunkteCheck(held2)
        held3.lebenspunkteCheck(held3)

        held1.lebenspunkte = maxOf(held1.lebenspunkte - seelenRaub, 0)
        held2.lebenspunkte = maxOf(held2.lebenspunkte - seelenRaub, 0)
        held3.lebenspunkte = maxOf(held3.lebenspunkte - seelenRaub, 0)*/

/*// 1 Version:
//        held1.lebenspunkte -= seelenRaub
//        held2.lebenspunkte -= seelenRaub
//        held3.lebenspunkte -= seelenRaub*/

        println(red + "------------------------------------------------------------------------------")
        println("Bal greift alle Helden mit seinem Seelenraub an und fügte Ihnen allen jeweils $seelenRaub Schaden zu!")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun seelenAnker() {
        var randomHeld = heldenListe.random()
        /*Ich hatte die Methode zuerst anders und habe dann gemerkt, dass ich die
         Lebenspunkte der Helden vergessen hatte und habe da nochmal Chat GPT gefragt.*/
        randomHeld.lebenspunkte = maxOf(randomHeld.lebenspunkte - seelenAnker, 0)

        println(red + "------------------------------------------------------------------------------")
        println("Molag Bal schmettert seinen Seelen Anker zu ${randomHeld.name} und fügt ihm $seelenAnker Schaden zu!")
        println("------------------------------------------------------------------------------" + reset)
    }


    fun seelenFluch() {
        var randomHeld = heldenListe.random()

        var zwanzigProzent = false
        //In der Variable steht die jeweilige LP des Helden drin
        var heldLP20 = (randomHeld.lebenspunkte * 0.2).toInt()
        while (!zwanzigProzent) {
            if (randomHeld.lebenspunkte > heldLP20) {
                /*Ich hatte die Methode zuerst anders und habe dann gemerkt, dass ich die
                Lebenspunkte der Helden vergessen hatte und habe da nochmal Chat GPT gefragt.*/
                randomHeld.lebenspunkte = maxOf(randomHeld.lebenspunkte - seelenFluch, 0)
                println(red + "------------------------------------------------------------------------------")
                println("\tMolag Bal verflucht den Helden ${randomHeld.name}")
                println("------------------------------------------------------------------------------" + reset)
                println(randomHeld.lebenspunkte)
            } else {
                zwanzigProzent = true
            }
        }

    }

    fun seelenZange(helden: Helden) {
        /*Ich hatte die Methode zuerst anders und habe dann gemerkt, dass ich die
        Lebenspunkte der Helden vergessen hatte und habe da nochmal Chat GPT gefragt.*/
        helden.lebenspunkte = maxOf(helden.lebenspunkte - seelenZange, 0)
        println(red + "------------------------------------------------------------------------------")
        println("Molag Bal schwingt seine Seelen Zange und trifft ${helden.name} und fügt ihm $seelenZange Schaden zu!")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun wuetendesSchnauben(helden: Helden) {

        helden.lebenspunkte = maxOf(helden.lebenspunkte - wuetendesSchnauben, 0)
        println(red + "------------------------------------------------------------------------------")
        println("Molag Bal schnaubt wütend und sein Atem trifft ${helden.name} und fügt ihm $wuetendesSchnauben Schaden zu!")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun verloreneSeeleSpawnt() {
        if (lebenspunkte <= 450 && !minibossSpawnt) {
            verloreneSeele = Miniboss("Seelen Leibeigener", wenigerLeben = 500)
            println(red + "------------------------------------------------------------------------------")
            println("Molag Bal ruft seinen Seelenleibeigenen herbei!" + reset)
            println("------------------------------------------------------------------------------")
            minibossSpawnt = true

        }
    }

    fun endbossAttacke() {
        var randomattack = listOf<Int>(1, 2, 3, 4, 5, 6).random()
        var randomHeld = heldenListe.random()

        if (randomHeld.lebenspunkte > 0) {
            when (randomattack) {
                1 -> seelenRaubausfuehren(held1, held2, held3) //Flächenschaden vom Endboss
                2 -> seelenAnker()
                3 -> seelenFluch()
                4 -> seelenZange(randomHeld)
                5 -> wuetendesSchnauben(randomHeld)
                6 -> verloreneSeeleSpawnt()
            }
        } else {
            println(yellow+"Der zufällig ausgewählte Held ist bereits besiegt und kann nicht angegriffen werden."+reset)
        }
        randomHeld.lebenspunkte > 0
    }

}
