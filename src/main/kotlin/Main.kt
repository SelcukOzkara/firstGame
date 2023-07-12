import Gegner.Dragon
import Utils.*

fun main() {
    startText()
    val myTeam = chooseTeam()
    val myBeutel = createBeutel()
    val minions = createMinions()
    val blackDragon = Dragon()
    battle(myTeam, myBeutel, blackDragon, minions)
}