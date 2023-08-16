import helden.Dunkelelf
import helden.Khajit
import helden.Ork
import kotlin.system.exitProcess


fun main() {


    println("\t\tWillkommen zum ESO RPG-Game")


    do {
        println("\t ============== Menü ==============")
        println("==== "+green+"1.Neues Spiel"+reset+" --- "+red+"2.Spiel beenden "+reset+" ====")
        println("Drücke Taste 1 oder 2")
        var userInput: Int
        userInput = try {
            readLine()?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            0
        }

        // Menüoptionen
        when (userInput) {
            1 -> {
                neuesSpiel()
            }

            2 -> {
                println("Auf Wiedersehen!")
                exitProcess(0)

            }

            else -> {
                println("Ungültige Eingabe. Bitte wähle eine Option (1 oder 2).")
            }
        }
    } while (userInput != 2)

}


fun neuesSpiel() {
    var isGameOver = false
    println("Neues Spiel wird gestartet...")
    println()
    println("=== Schatten über Tamriel ===")
    println(
        """
        |Kapitel 1: Das Erwachen der Dunkelheit|
        In einer Welt voller Magie und Abenteuer, in der die Lande von Tamriel blühen,
        breitet sich eine Dunkelheit aus, die alles zu verschlingen droht. Dichter Nebel 
        und düstere Schatten hüllen die Wälder in Dunkelheit, und überall sind Seelenlose zu sehen. 
        Nachtschatten, der gewandte Khajit-Dieb, Anarwen, der geheimnisvolle Dunkelelf, und Horak, 
        der kraftvolle Ork-Krieger, finden sich inmitten dieser bedrohlichen Situation wieder.
        
        
    """.trimIndent()
    ) //Das habe ich von ChatGpt, da mir der Text immer falsch formatiert wurde, wurde mir das hier vorgeschlagen.
    Thread.sleep(500)
    println(
        """
    |Kapitel 2: Die Reise ins Ungewisse|
    Die Helden werden durch eine Vision vereint, die ihnen die drohende Gefahr von Molag Bal zeigt, 
    einem mächtigen Daedra-Prinzen, der die Seelen der Einwohner von Tamriel für sich beanspruchen will. 
    Entschlossen, diese Bedrohung abzuwenden, begeben sich die Helden auf eine gefährliche Reise durch 
    die dunklen Wälder von Tamriel. Der Nebel und die Schatten scheinen lebendig zu sein und lauern überall, 
    während die Seelenlosen nach ihnen greifen.
    
    
    """.trimIndent()
    )

    Thread.sleep(500)
    println(
        """
    |Kapitel 3: Der Endboss und die Entscheidung|
    Endlich erreichen die Helden den Ort, an dem Molag Bal seine finsteren Pl1ne schmiedet. 
    Dort stehen sie seinem Schrecken gegenüber, als er versucht, die Seelen der Einwohner von 
    Tamriel zu verschlingen, um unermessliche Macht zu erlangen. In einem epischen Kampf setzen die Helden 
    all ihre Fähigkeiten und Stärken ein, um Molag Bal entgegenzutreten. Doch der Kampf ist nicht leicht, und 
    die Dunkelheit scheint alles zu verschlingen.
     """.trimIndent()
    )

    println()
    println(red+"==============================================")
    println("*** Molag Bal erscheint aus der Finsternis ***")
    println("=============================================="+reset)
    kampfRunde()


}






