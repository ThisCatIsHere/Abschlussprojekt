import helden.Dunkelelf
import helden.Khajit
import helden.Ork
import kotlin.concurrent.thread
import kotlin.system.exitProcess


fun main() {

    // Begrüßungstext
    println("\t\tWillkommen zum ESO RPG-Game")

    //DO-While Schleife, die das Menü des Spiels anzeigt
    do {
        println("\t ============== Menü ==============")
        println("==== " + green + "1.Neues Spiel" + reset + " --- " + red + "2.Spiel beenden " + reset + " ====")
        println("Drücke Taste 1 oder 2")

        //Benutzereingabe
        var userInput: Int
        userInput = try {
            readLine()?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            0
        }

        // Menüoptionen
        when (userInput) {
            1 -> {
                //Startet das Spiel
                neuesSpiel()
            }

            2 -> {
                //Beendet das Spiel
                println("Auf Wiedersehen!")
                exitProcess(0)

            }

            else -> {
                println("Ungültige Eingabe. Bitte wähle eine Option (1 oder 2).")
            }
        }
        // Die Schleife läuft, bis der Benutzer das Spiel beendet
    } while (userInput != 2)

}


fun neuesSpiel() {
    var isGameOver = false
    println("Neues Spiel wird gestartet...")
    println()
    println("=== Schatten über Tamriel ===")
    var text1 = """
        |Kapitel 1: Das Erwachen der Dunkelheit|
        In einer Welt voller Magie und Abenteuer, in der die Lande von Tamriel blühen,
        breitet sich eine Dunkelheit aus, die alles zu verschlingen droht. Dichter Nebel 
        und düstere Schatten hüllen die Wälder in Dunkelheit, und überall sind Seelenlose zu sehen. 
        Nachtschatten, der gewandte Khajit-Dieb, Anarwen, der geheimnisvolle Dunkelelf, und Horak, 
        der kraftvolle Ork-Krieger, finden sich inmitten dieser bedrohlichen Situation wieder.
        """
    //Das mit trimIndent().lines() hat Benni mir gezeigt und erklärt.

    val lines = text1.trimIndent().lines()
    for (line in lines) {
        println(line)
        Thread.sleep(500)
    }
    spacer(2)
    var text2 = """
        |Kapitel 2: Die Reise ins Ungewisse|
        Die Helden werden durch eine Vision vereint, die ihnen die drohende Gefahr von Molag Bal zeigt, 
        einem mächtigen Daedra-Prinzen, der die Seelen der Einwohner von Tamriel für sich beanspruchen will. 
        Entschlossen, diese Bedrohung abzuwenden, begeben sich die Helden auf eine gefährliche Reise durch 
        die dunklen Wälder von Tamriel. Der Nebel und die Schatten scheinen lebendig zu sein und lauern überall, 
        während die Seelenlosen nach ihnen greifen. """
    val lines2 = text2.trimIndent().lines()
    for (line in lines2) {
        println(line)
        Thread.sleep(500)
    }
    spacer(2)
    var text3 = """
        |Kapitel 3: Der Endboss und die Entscheidung|
        Endlich erreichen die Helden den Ort, an dem Molag Bal seine finsteren Pl1ne schmiedet. 
        Dort stehen sie seinem Schrecken gegenüber, als er versucht, die Seelen der Einwohner von 
        Tamriel zu verschlingen, um unermessliche Macht zu erlangen. In einem epischen Kampf setzen die Helden 
        all ihre Fähigkeiten und Stärken ein, um Molag Bal entgegenzutreten. Doch der Kampf ist nicht leicht, und 
        die Dunkelheit scheint alles zu verschlingen.
         """
    val lines3 = text3.trimIndent().lines()
    for (line in lines3) {
        println(line)
        Thread.sleep(500)
    }


    println()
    //Benni hat mir gezeigt wie man einfacher die Farben nutzen kann, als nur den Farbcode rein zu schreiben
    println(red + "==============================================")
    println("*** Molag Bal erscheint aus der Finsternis ***")
    println("==============================================" + reset)
    //Hier wir die Funktion für die Kampfrunde aufgerufen
    kampfRunde()


}






