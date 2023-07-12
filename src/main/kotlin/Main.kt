import Gegner.Dragon
import Utils.*

/* TODO:
    3) Konsolenausgaben anpassen
    4) Falls Zeit -> Gegner.Dragon mehrere Leben geben -> Stage 1-3
 */

fun main() {

    startText()
    val myTeam = chooseTeam()
    val myBeutel = createBeutel()
    val minions = createMinions()
    val blackDragon = Dragon()
    battle(myTeam, myBeutel, blackDragon, minions)

}