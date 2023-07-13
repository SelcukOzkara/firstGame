import Gegner.Dragon
import Utils.*

/* Instanziieren vom Team, Beutel/Inventar, Gegner über die jeweiligen Funktionen.
Aufruf der Funktion battle mit der übergabe der Objekte
 */
fun main() {
    startText()
    val myTeam = chooseTeam()
    val myBeutel = createBeutel()
    val minions = createMinions()
    val blackDragon = Dragon()
    battle(myTeam, myBeutel, blackDragon, minions)
}