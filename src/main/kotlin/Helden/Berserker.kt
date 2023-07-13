package Helden

import Utils.cRed
import Utils.cReset
import Utils.cYellow

/* Übernahme durch die Mutterklasse mit gesetzten Default werten, welche durch den Init Block
die jeweiligen Werte erhalten für die Heldenklasse
 */
class Berserker : Held(name = "", maxHp = 0, hp = 0, damage = 0, shield = false, isPoison = false) {
    var focus = false

    init {
        this.name = "Bero der Berserker"
        this.maxHp = 110
        this.hp = maxHp
        this.damage = 60
    }

    /* die Methode Aktion beinhaltet das Auswahlmenü für die jeweiligen Helden
       Ausgabe vom ASCII Code | Generiert über http://www.network-science.de/ascii/
     */
    override fun aktion(): Int {
        while (true) {
            println(
                """
                
              ____                          _             
             |  _ \                        | |            
             | |_) | ___ _ __ ___  ___ _ __| | _____ _ __ 
             |  _ < / _ \ '__/ __|/ _ \ '__| |/ / _ \ '__|
             | |_) |  __/ |  \__ \  __/ |  |   <  __/ |   
             |____/ \___|_|  |___/\___|_|  |_|\_\___|_|   
            
             ${this.name}
             HP: $cRed${this.hp}$cReset | Schild: ${this.shield}
        ┌────────────────────────────────────────────────┐      
        │   [1] Hieb                [2] Tausend Dolche   │
        │   [3] Fokus               [4] Schild           │
        │                                                │
        │   [5] ${cYellow}Beutel$cReset                                   │
        └────────────────────────────────────────────────┘
            
            Wählen Sie aus:
        """.trimIndent()
            )
            try {
                val input = readln().toInt()
                if (input !in 1..5) throw Exception("")

                when (input) {
                    1 -> {
                        this.damage += attack(input)
                        return this.damage
                    }

                    2 -> {
                        this.damage += attack(input)
                        return this.damage
                    }

                    3 -> {
                        this.focus = true
                        return 0
                    }

                    4 -> {
                        this.shield = true
                        return 0
                    }

                    5 -> return -2
                }
                break
            } catch (e: Exception) {
                println("Bitte wähle aus einen Angriff aus!")
            }
        }
        return 0
    }

    override fun toString(): String {
        return "Berserker | Name: ${this.name} HP: $cRed${this.hp}$cReset"
    }

    //Gibt je nach Auswahl des Users einen Wert zurück
    override fun attack(angriff: Int): Int {
        if (this.focus) {
            if (angriff == 1) {
                this.focus = false
                return (20..60).random() + 100
            } else if (angriff == 2) {
                this.focus = false
                return (40..90).random() + 100
            }
        } else {
            if (angriff == 1) {
                return (20..60).random() + 100
            } else if (angriff == 2) {
                return (40..90).random() + 100
            }
        }
        return 0
    }
}