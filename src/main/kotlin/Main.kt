/* TODO:
    3) Konsolenausgaben anpassen
    4) Falls Zeit -> Dragon mehrere Leben geben -> Stage 1-3
    5) Falls Zeit -> Ausweichen hinzufügen
 */

fun main() {

   startText()
   val myTeam = chooseTeam()
   val myBeutel = createBeutel()
   val minions = createMinions()
   val blackDragon = Dragon()
   battle(myTeam,myBeutel,blackDragon,minions)

}