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
                        println("${minion.name} führt den Angriff 'Schubser' aus.")
                        if (held.hp > 0 && !held.shield) {
                            held.hp -= (5..8).random()
                            println("${held.name} HP: ${held.hp}")
                        } else if (held.shield) {
                            held.shield = false
                            println("${held.name} hatte ein Schild!")
                        } else println("Keinen getroffen...")
                    }

                    2 -> {
                        val held = myTeam.random()
                        println("${minion.name} führt den Angriff 'Stockschlag' aus.")
                        if (held.hp > 0 && !held.shield) {
                            held.hp -= (15..20).random()
                            println("${held.name} HP: ${held.hp}")
                        } else if (held.shield) {
                            held.shield = false
                            println("${held.name} hatte ein Schild!")
                        } else println("Keinen getroffen...")
                    }

                    3 -> {
                        val held = myTeam.random()
                        println("${minion.name} führt den Angriff 'Peitsche' aus.")
                        if (held.hp > 0 && !held.shield) {
                            held.hp -= (30..38).random()
                            println("${held.name} HP: ${held.hp}")
                        } else if (held.shield) {
                            held.shield = false
                            println("${held.name} hatte ein Schild!")
                        } else println("Keinen getroffen...")
                    }

                    4 -> {
                        val held = myTeam.random()
                        println("${minion.name} führt den Angriff 'Steinwurf' aus.")
                        if (held.hp > 0 && !held.shield) {
                            held.hp -= 60
                            println("${held.name} HP: ${held.hp}")
                        } else if (held.shield) {
                            held.shield = false
                            println("${held.name} hatte ein Schild!")
                        } else println("Keinen getroffen...")
                    }
                }
            }
        }
    }
}