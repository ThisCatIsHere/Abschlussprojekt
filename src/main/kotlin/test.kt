import gegner.Endboss
import helden.Helden

fun main() {
    var endboss: Endboss = Endboss("Molag Bal", 1000)
    var held: Helden = Helden("Khajit", 750)

    endboss.seelenFluch()
    println(held.lebenspunkte)

}