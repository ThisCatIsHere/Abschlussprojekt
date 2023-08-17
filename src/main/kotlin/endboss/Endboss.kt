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

//Eine neue Klasse "Endboss", welche von der Klasse "Gegner" erbt.
class Endboss(name: String, lebenspunkte: Int) : Gegner(name, lebenspunkte) {
    var maxLebenspunkte: Int = 900
    //soll alle helden treffen
    var seelenRaub: Int = 300
    var seelenAnker: Int = 250
    //soll nur einen helden treffen,//10% pro Held, pro runde bis HP weniger als 20%
    var seelenFluch: Int = 100
    var seelenZange: Int = 50
    var wuetendesSchnauben: Int = 25
    //erst wenn der Endboss nur noch 50% leben hat
    var verloreneSeele: Miniboss? = null


// Es folgen die Methoden vom Endboss

    /*Ich hatte die Methode zuerst anders und habe dann gemerkt, dass ich die
      Lebenspunkte der Helden vergessen hatte und habe da nochmal Chat GPT gefragt.*/

    //Flächenschaden vom Endboss auf alle Helden, sofern sie noch am leben sind.
    //Die Funktion bekommt als Parameter eine Liste von Helden, von der Klasse Helden
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
        // Eine Schleife wird ausgeführt, solange der Fluch nicht bei 20% der Lebenspunkte angekommen ist
        while (!zwanzigProzent) {
            // Wenn die Lebenspunkte des zufällig ausgewählten Helden über 20% liegen
            if (randomHeld.lebenspunkte > heldLP20) {

                /*Ich hatte die Methode zuerst anders und habe dann gemerkt, dass ich die
                Lebenspunkte der Helden vergessen hatte und habe da nochmal Chat GPT gefragt.*/

                // Die Lebenspunkte des Helden werden um den Schaden des Fluchs reduziert (0 ist das Minimum)
                randomHeld.lebenspunkte = maxOf(randomHeld.lebenspunkte - seelenFluch, 0)
                // Eine Meldung wird ausgegeben, die den verfluchten Helden und seine aktualisierten Lebenspunkte anzeigt
                println(red + "------------------------------------------------------------------------------")
                println("\tMolag Bal verflucht den Helden ${randomHeld.name}")
                println("------------------------------------------------------------------------------" + reset)
                println(randomHeld.lebenspunkte)
            } else {
                // Wenn die Lebenspunkte des Helden unter 20% fallen, wird die Schleife beendet
                zwanzigProzent = true
            }
        }

    }

    fun seelenZange(helden: Helden) {
        /*Ich hatte die Methode zuerst anders und habe dann gemerkt, dass ich die
        Lebenspunkte der Helden vergessen hatte und habe da nochmal Chat GPT gefragt.*/

        // Die Lebenspunkte des übergebenen Helden werden um den Schaden der Seelenzange reduziert
        helden.lebenspunkte = maxOf(helden.lebenspunkte - seelenZange, 0)
        println(red + "------------------------------------------------------------------------------")
        println("Molag Bal schwingt seine Seelen Zange und trifft ${helden.name} und fügt ihm $seelenZange Schaden zu!")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun wuetendesSchnauben(helden: Helden) {

        // Die Lebenspunkte des übergebenen Helden werden um den Schaden des wütenden Schnaubens reduziert
        helden.lebenspunkte = maxOf(helden.lebenspunkte - wuetendesSchnauben, 0)
        println(red + "------------------------------------------------------------------------------")
        println("Molag Bal schnaubt wütend und sein Atem trifft ${helden.name} und fügt ihm $wuetendesSchnauben Schaden zu!")
        println("------------------------------------------------------------------------------" + reset)
    }

    fun verloreneSeeleSpawnt() {
        // Überprüft, ob die Lebenspunkte des Endbosses unter oder gleich 450 liegen und ob der Miniboss noch nicht gespawnt ist
        if (lebenspunkte <= 450 && !minibossSpawnt) {
            // Erstellt eine Instanz des Minibosses "Seelen Leibeigener" mit vorgegebenen Lebenspunkten (wenigerLeben)
            verloreneSeele = Miniboss("Seelen Leibeigener")
            println(red + "------------------------------------------------------------------------------")
            println("Molag Bal ruft seinen Seelenleibeigenen herbei!" + reset)
            println("------------------------------------------------------------------------------")

            // Setzt den Status minibossSpawnt auf true, um sicherzustellen, dass der Miniboss nicht erneut gespawnt wird
            minibossSpawnt = true

        }
    }

    fun endbossAttacke() {
        // Zufällige Auswahl einer Angriffsaktion und eines zufälligen Helden aus der Liste der Helden
        var randomattack = listOf<Int>(1, 2, 3, 4, 5, 6).random()
        var randomHeld = heldenListe.random()

        // Überprüfung, ob der ausgewählte zufällige Held noch Lebenspunkte hat
        if (randomHeld.lebenspunkte > 0) {
            // Je nach zufälliger Angriffsaktion wird eine entsprechende Funktion aufgerufen
            when (randomattack) {
                1 -> seelenRaubausfuehren(heldenListe) //Flächenschaden vom Endboss
                2 -> seelenAnker(randomHeld)
                3 -> seelenFluch(randomHeld)
                4 -> seelenZange(randomHeld)
                5 -> wuetendesSchnauben(randomHeld)
                6 -> verloreneSeeleSpawnt()
            }
        } else {
            // Wenn der ausgewählte Held bereits besiegt wurde, wird eine Meldung ausgegeben
            println(yellow+"Der zufällig ausgewählte Held ist bereits besiegt und kann nicht angegriffen werden."+reset)
        }
        // Die Funktion gibt einen booleschen Wert zurück, der in diesem Kontext jedoch keine Auswirkungen hat
        randomHeld.lebenspunkte > 0
    }

}
