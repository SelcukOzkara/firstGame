package Gegner

import Helden.Held

class Dragon : Gegner(name = "", hp = 100) {
    var minions = false
    var i = mutableListOf(
        1,
        1,
        1,
        1,
        2,
        2,
        2,
        2,
        3,
        3,
        3,
        4,
        4,
        4,
        5,
        5,
        5,
        5,
        5,
        5,
        5,
        5,
        5,
        5,
        5,
        5,
        6,
        6,
        6,
        6,
        6,
        6,
        6,
        6,
        6,
        6,
        6,
        6,
        6,
        6
    )

    init {
        this.name = "Black Dragon"
        this.hp = 4000
    }

    override fun attack(myTeam: MutableList<Held>, minion: Gegner, enemy: Dragon) {
        while (true) {
            var j = (0 until myTeam.size).random()
            if (myTeam[j].hp > 0) {
                when (i.random()) {
                    1 -> {
                        println("${this.name} führt den Angriff 'Schwarze Flamme' aus.")
                        if (!myTeam[j].shield) {
                            myTeam[j].hp -= (40..120).random()
                            if (myTeam[j].hp < 0) myTeam[j].hp = 0
                            println("${myTeam[j].name} wurde angegriffen! HP: ${myTeam[j].hp}")
                            break
                        } else {
                            myTeam[j].shield = false
                            println("${myTeam[j].name} hatte ein Schild!")
                            break
                        }
                    }

                    2 -> {
                        println("${this.name} führt den Angriff 'Felswurf' aus.")
                        if (!myTeam[j].shield) {
                            myTeam[j].hp -= (50..60).random()
                            if (myTeam[j].hp < 0) myTeam[j].hp = 0
                            println("${myTeam[j].name} wurde angegriffen! HP: ${myTeam[j].hp}")
                            break
                        } else {
                            myTeam[j].shield = false
                            println("${myTeam[j].name} hatte ein Schild!")
                            break
                        }
                    }

                    3 -> {
                        enemy.hp += (200..500).random()
                        println("${enemy.name} heilt sich und hat jetzt wieder ${enemy.hp} HP.")
                        break
                    }

                    4 -> {
                        println("${this.name} führt den Angriff 'Eisatem' aus.")
                        myTeam.forEach {
                            if (it.hp > 0) {
                                it.hp -= (40..60).random()
                                println("${it.name} wurde getroffen! HP:${it.hp}")
                            }
                        }
                        break
                    }

                    5 -> {
                        println("${this.name} führt den Angriff 'Giftwolke' aus.")
                        if (!myTeam[j].shield) {
                            myTeam[j].isPoison = true
                            println("${myTeam[j].name} wurde vergiftet! HP: ${myTeam[j].hp}")
                            break
                        } else {
                            myTeam[j].shield = false
                            println("${myTeam[j].name} hatte ein Schild!")
                            break
                        }
                    }

                    6 -> {
                        this.minions = true
                        println("${this.name} hat drei Minions beschworen.")
                        i.removeAll { it == 6 }
                        break
                    }
                }
            }
        }
    }
}