/* TODO:
    1) Item's einführen
         - Wiederbelebungstrank
         - eventuell Waffen
    2) AOE Angriff vom Dragon programmieren
    3) Konsolenausgaben anpassen
    4) Falls Zeit -> Dragon mehrere Leben geben -> Stage 1-3
 */

fun main() {

   startText()
   val myTeam = chooseTeam()
   val blackDragon = Dragon()
   battle(myTeam,blackDragon)

}