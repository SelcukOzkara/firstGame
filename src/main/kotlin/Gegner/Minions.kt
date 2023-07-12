package Gegner

import Helden.Held

class Minions : Gegner(name = "", hp = 0) {
    init {
        this.name = "Minion"
        this.hp = 800
    }

    override fun toString(): String {
        return "${this.name} + ${this.hp}"
    }

    override fun attack(myTeam: MutableList<Held>, minion: Gegner, enemy: Dragon) {
        if (enemy.minions) {
            val j = mutableListOf(1, 1, 1, 1, 2, 2, 2, 3, 3, 4).random()
            if (minion.hp > 0) {
                when (j) {
                    1 -> {
                        val held = myTeam.random()
                        println("""
                            
                            (ง ͠ ᵒ̌ Дᵒ̌ )▬▬ι═══════ﺤ
                        ┌──────────────────────────────────────────────────────────────┐ 
                         ${minion.name} führt den Angriff 'Schubser' aus.
                        """.trimIndent())
                        if (held.hp > 0 && !held.shield) {
                            held.hp -= (5..8).random()
                            println("""
                                ${held.name} HP: ${held.hp}
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                        } else if (held.shield) {
                            held.shield = false
                            println("""
                                ${held.name} hatte ein Schild!
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                        } else println("""
                                Keinen getroffen...
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                    }

                    2 -> {
                        val held = myTeam.random()
                        println("""
                            
                            (ง ͠ ᵒ̌ Дᵒ̌ )▬▬ι═══════ﺤ
                        ┌──────────────────────────────────────────────────────────────┐ 
                         ${minion.name} führt den Angriff 'Stockschlag' aus.
                        """.trimIndent())
                        if (held.hp > 0 && !held.shield) {
                            held.hp -= (15..20).random()
                            println("""
                                ${held.name} HP: ${held.hp}
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                        } else if (held.shield) {
                            held.shield = false
                            println("""
                                ${held.name} hatte ein Schild!
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                        } else println("""
                                Keinen getroffen...
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                    }

                    3 -> {
                        val held = myTeam.random()
                        println("""
                            
                            (ง ͠ ᵒ̌ Дᵒ̌ )▬▬ι═══════ﺤ
                        ┌──────────────────────────────────────────────────────────────┐ 
                         ${minion.name} führt den Angriff 'Stockschlag' aus.
                        """.trimIndent())
                        if (held.hp > 0 && !held.shield) {
                            held.hp -= (30..38).random()
                            println("""
                                ${held.name} HP: ${held.hp}
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                        } else if (held.shield) {
                            held.shield = false
                            println("""
                                ${held.name} hatte ein Schild!
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                        } else println("""
                                Keinen getroffen...
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                    }

                    4 -> {
                        val held = myTeam.random()
                        println("""
                            
                            (ง ͠ ᵒ̌ Дᵒ̌ )▬▬ι═══════ﺤ
                        ┌──────────────────────────────────────────────────────────────┐ 
                         ${minion.name} führt den Angriff 'Steinwurf' aus.
                        """.trimIndent())
                        if (held.hp > 0 && !held.shield) {
                            held.hp -= 60
                            println("""
                                ${held.name} HP: ${held.hp}
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                        } else if (held.shield) {
                            held.shield = false
                            println("""
                                ${held.name} hatte ein Schild!
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                        } else println("""
                                Keinen getroffen...
                            └──────────────────────────────────────────────────────────────┘
                            """.trimIndent())
                    }
                }
            }
        }
    }
}