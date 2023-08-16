package endboss

import held
import held2
import held3
import helden.Helden
import heldenListe
import lebenspunkteCheck

import minibossSpawnt
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
    fun seelenRaubausfuehren(helden: MutableList<Helden>) {
        for (held in helden){
            if (held.lebtHeldNoch) {
                held.lebenspunkte -= seelenRaub
                lebenspunkteCheck(held)
                println(red + "------------------------------------------------------------------------------")
                println("${held.name} wurde vom Seelenraub getroffen und hat nun ${held.lebenspunkte} Lebenspunkte.")
                println("------------------------------------------------------------------------------" + reset)
            } else {
                println(yellow+"${held.name} ist bereits besiegt und kann nicht angegriffen werden."+reset)
            }

        }


        println(red + "------------------------------------------------------------------------------")
        println("Bal greift alle Helden mit seinem Seelenraub an und fügte Ihnen allen jeweils $seelenRaub Schaden zu!")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun seelenAnker(randomHeld: Helden) {

        /*Ich hatte die Methode zuerst anders und habe dann gemerkt, dass ich die
         Lebenspunkte der Helden vergessen hatte und habe da nochmal Chat GPT gefragt.*/
        randomHeld.lebenspunkte = maxOf(randomHeld.lebenspunkte - seelenAnker, 0)

        println(red + "------------------------------------------------------------------------------")
        println("Molag Bal schmettert seinen Seelen Anker zu ${randomHeld.name} und fügt ihm $seelenAnker Schaden zu!")
        println("------------------------------------------------------------------------------" + reset)
    }


    fun seelenFluch(randomHeld: Helden) {


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
                1 -> seelenRaubausfuehren(heldenListe) //Flächenschaden vom Endboss
                2 -> seelenAnker(randomHeld)
                3 -> seelenFluch(randomHeld)
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
