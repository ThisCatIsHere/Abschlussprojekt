import gegner.Endboss
import gegner.Miniboss
import helden.Dunkelelf
import helden.Helden
import helden.Khajit
import helden.Ork

var minibossSpawnt = false

var held1 = Khajit("Nachtklinge")
var held2 = Ork("Horak", extraLebenspunkte = 150)
var held3 = Dunkelelf("Anarwen", wenigerLeben = 250)

var endboss = Endboss("MolagBal")
var miniboss = Miniboss("Seelen Leibeigener", wenigerLeben = 2500)



//Die battlemenüs müssen noch angepasst werden wie beim Dunkelelf
fun heldenMenue(): Helden? {
    println("Wähle deinen Helden:")
    println("1 = Khajit | 2 = Dunkelelf | 3 = Ork | 4 = Abbrechen")

    var userInput: Int
    userInput = try {
        readLine()?.toInt() ?: 0
    } catch (e: NumberFormatException) {
        0
    }

    return when (userInput) {
        1 -> Khajit("Khajit")
        2 -> Dunkelelf("Dunkelelf", wenigerLeben = 250)
        3 -> Ork("Horak", 200)
        4 -> null

        else -> {
            println("Ungültige Eingabe. Bitte wähle 1 - 4.")
            heldenMenue()
        }
    }

}
// * Battlemenü vom Khajiten
fun battlemenueKhajit(helden: Khajit, gegner: Endboss) {
    println("Wähle nun deine Aktion aus")
    println("1 = Assassinen Klinge | 2 = Schattenschuss | 3 = Verwirrungsschlag | 4 = Mondsichelgranate | 5 = Abbrechen")

    var userInput: Int
    userInput = try {
        readLine()?.toInt() ?: 0
    } catch (e: NumberFormatException) {
        0
    }
    when (userInput) {
        1 -> {
            helden.assassinenKlinge(gegner)
        }

        2 -> {
            helden.schattenSchuss(gegner)
        }

        3 -> {
            helden.verwirrungsSchlag(gegner)
        }

        4 -> {
            helden.mondsichelGranate(gegner)
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

// *Battlemenü vom Ork
fun battlemenueOrk(helden: Ork, gegner: Endboss) {
    println("Wähle nun deine Aktion aus")
    println("1 = Blockade | 2 = Versengender Schlag | 3 = Ketten der Verwüstung | 4 = Glutgranate | 5 = Abbrechen")

    var userInput: Int
    userInput = try {
        readLine()?.toInt() ?: 0
    } catch (e: NumberFormatException) {
        0
    }
    when (userInput) {
        1 -> {
            helden.blockade(gegner)
        }

        2 -> {
            helden.versengenderSchlag(gegner)
        }

        3 -> {
            helden.kettenDerVerwuestung(gegner)
        }

        4 -> {
            helden.glutGranate(gegner)
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

