package Helden

import Utils.cGreen
import Utils.cRed
import Utils.cReset

class Magier : Held(name = "", maxHp = 0, hp = 0, damage = 0, shield = false, isPoison = false) {

    init {
        this.name = "Gandalf der Magier"
        this.maxHp = 100
        this.hp = maxHp
        this.damage = 0
    }

    override fun aktion(): Int {
        while (true) {
            println(
                """
                
              __  __             _           
             |  \/  |           (_)          
             | \  / | __ _  __ _ _  ___ _ __ 
             | |\/| |/ _` |/ _` | |/ _ \ '__|
             | |  | | (_| | (_| | |  __/ |   
             |_|  |_|\__,_|\__, |_|\___|_|   
                           __/ |            
                          |___/  
             ${this.name}
             HP: $cRed${this.hp}$cReset | Schild: ${this.shield}
        ┌───────────────────────────────────────────────┐        
        │   [1] Feuersturm          [2] Hagelschauer    │
        │   [3] Heilen              [4] Schild          │
        │                                               │
        │   [5] Beutel                                  │
        └───────────────────────────────────────────────┘    
            
            Wählen Sie aus:
        """.trimIndent()
            )
            try {
                val input = readln().toInt()
                if (input !in 1..5) throw Exception("")

                when (input) {
                    1 -> {
                        this.damage = attack(input)
                        return this.damage
                    }

                    2 -> {
                        this.damage = attack(input)
                        return this.damage
                    }

                    3 -> {
                        return -1
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
        return "Magier | Name: ${this.name} HP: $cRed${this.hp}$cReset"
    }

    override fun attack(angriff: Int): Int {
        return if (angriff == 1) (40..60).random()
        else (40..100).random()
    }

}