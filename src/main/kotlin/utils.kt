import kotlin.math.min

fun startText() {
    println(
        """
        
   ▄██████▄   ▄██████▄   ▄█       ████████▄     ▄████████ ███▄▄▄▄           ▄████████ ▄██   ▄   ███▄▄▄▄       ███        ▄████████ ▀████    ▐████▀ 
  ███    ███ ███    ███ ███       ███   ▀███   ███    ███ ███▀▀▀██▄        ███    ███ ███   ██▄ ███▀▀▀██▄ ▀█████████▄   ███    ███   ███▌   ████▀  
  ███    █▀  ███    ███ ███       ███    ███   ███    █▀  ███   ███        ███    █▀  ███▄▄▄███ ███   ███    ▀███▀▀██   ███    ███    ███  ▐███    
 ▄███        ███    ███ ███       ███    ███  ▄███▄▄▄     ███   ███        ███        ▀▀▀▀▀▀███ ███   ███     ███   ▀   ███    ███    ▀███▄███▀    
▀▀███ ████▄  ███    ███ ███       ███    ███ ▀▀███▀▀▀     ███   ███      ▀███████████ ▄██   ███ ███   ███     ███     ▀███████████    ████▀██▄     
  ███    ███ ███    ███ ███       ███    ███   ███    █▄  ███   ███               ███ ███   ███ ███   ███     ███       ███    ███   ▐███  ▀███    
  ███    ███ ███    ███ ███▌    ▄ ███   ▄███   ███    ███ ███   ███         ▄█    ███ ███   ███ ███   ███     ███       ███    ███  ▄███     ███▄  
  ████████▀   ▀██████▀  █████▄▄██ ████████▀    ██████████  ▀█   █▀        ▄████████▀   ▀█████▀   ▀█   █▀     ▄████▀     ███    █▀  ████       ███▄ 
                        ▀                                                                                                                                                                                               
    """.trimIndent()
    )
}

fun chooseTeam(): MutableList<Held> {
    val helden = mutableListOf<Held>()

    println(
        """
       ┌─────────────────────────────────┐
       │ Wähle drei Helden für dein Team │
       └─────────────────────────────────┘
       
        [1] ${Ritter()}
        [2] ${Magier()}
        [3] ${Berserker()}
        
    """.trimIndent()
    )

    var i = 0
    while (i < 3) {
        try {
            val input = readln().toInt()
            if (input !in 1..3) throw Exception("")
            when (input) {
                1 -> {
                    helden.add(Ritter())
                    println(
                        """
                        
                        ┌──────────────────────────────────────────────────────┐
                        │Der Ritter wurde erfolgreich in dein Team hinzugefügt!│
                        └──────────────────────────────────────────────────────┘
                        
                    """.trimIndent()
                    )
                }

                2 -> {
                    helden.add(Magier())
                    println(
                        """
                        
                        ┌──────────────────────────────────────────────────────┐
                        │Der Magier wurde erfolgreich in dein Team hinzugefügt!│
                        └──────────────────────────────────────────────────────┘
                        
                    """.trimIndent()
                    )
                }

                3 -> {
                    helden.add(Berserker())
                    println(
                        """
                        
                        ┌─────────────────────────────────────────────────────────┐
                        │Der Berserker wurde erfolgreich in dein Team hinzugefügt!│
                        └─────────────────────────────────────────────────────────┘
                        
                    """.trimIndent()
                    )
                }
            }
            i++
        } catch (e: Exception) {
            println("Falsche eingabe!")
            continue
        }

    }
    return helden
}

fun createMinions(): MutableList<Gegner> {
    return mutableListOf(Minions(), Minions(), Minions())
}

fun createBeutel(): MutableList<Item> {
    return mutableListOf(Heal(), Reviv())
}

fun battle(myTeam: MutableList<Held>, myBeutel: MutableList<Item>, enemy: Dragon, minions: MutableList<Gegner>) {
    while (!death(myTeam, enemy)) {
        println("\nIn deinem Team leben noch:")
        for (i in myTeam){
            if (i.hp > 0){
                println("""
                ${i.name} mit ${i.hp} HP
            """.trimIndent())
            }
        }
        for (i in myTeam) {
            if (i.hp > 0 && enemy.hp > 0) {
                checkPoison(i)
                playerRound(myTeam, myBeutel, enemy, minions, i)
            } else continue
        }

        if (!death(myTeam, enemy)) {
            enemyRound(myTeam, enemy, minions)
        }
    }
}

fun checkPoison(i: Held) {
    if (i.isPoison && i.hp > (i.maxHp * 0.2).toInt()) {
        i.hp -= (i.maxHp * 0.1).toInt()
    } else if (i.isPoison && i.hp <= (i.maxHp * 0.2).toInt()) {
        i.isPoison = false
    }
}

fun playerRound(
    myTeam: MutableList<Held>,
    myBeutel: MutableList<Item>,
    enemy: Dragon,
    minions: MutableList<Gegner>,
    i: Held
) {
    while (true) {
        var check = 0
        var attack = myTeam[myTeam.indexOf(i)].aktion()
        if (attack == -1) {
            println("""
                
                ++++++++++++++++++++++++++++++++++++
                ++++++++Alle wurden geheilt!++++++++
            """.trimIndent())
            myTeam.forEach {
                if (it.hp > 0){
                    it.hp += 50
                    println("${it.name} | ${it.hp} HP")
                }
            }
            println("""
                ++++++++++++++++++++++++++++++++++++
                
            """.trimIndent())
            break
        } else if (attack == -2) {
            while (true) {
                println(
                    """
                            
                            [1] ${myBeutel[0]}
                            [2] ${myBeutel[1]}
                            
                            [0] Abbrechen 
                            
                        """.trimIndent()
                )
                try {
                    val input = readln().toInt()
                    if (input !in 1..myBeutel.size && input != 0) throw Exception("")

                    when (input) {
                        1 -> {
                            if (myBeutel[0].anzahl <= 0) throw Exception("Du hast keinen Trank mehr!")
                            myBeutel[0].anzahl -= 1
                            i.hp += 50
                            check = 1
                            break
                        }

                        2 -> {
                            var toteHelden = mutableListOf<Held>()
                            for (j in myTeam) {
                                if (j.hp <= 0) {
                                    j.hp = 0
                                    toteHelden.add(j)
                                }
                            }
                            if (myBeutel[1].anzahl <= 0) throw Exception("Du hast keinen Trank mehr!")
                            if (toteHelden.isNotEmpty()) {
                                toteHelden.forEach { println(it) }
                                println("Welchen Helden möchtest du wiederbeleben? 1-${toteHelden.size}")
                                val input = readln().toInt() - 1
                                toteHelden[input].hp = 100
                                toteHelden.removeAt(input)
                                myBeutel[1].anzahl -= 1
                                check = 1
                            } else println("Alle deine Helden leben noch!")
                            break
                        }

                        0 -> break
                    }
                    break
                } catch (e: Exception) {
                    println("Bitte wähle ein Item aus")
                }
            }
            if (check == 1) break
            else continue

        } else {
            if (enemy.minions) {
                var c = 1
                if (minions[0].hp == 0 && minions[1].hp == 0 && minions[2].hp == 0) {
                    break
                }
                for (j in minions) {
                    if (j.hp == 0) {
                        continue
                    }
                    if (j.hp > 0) {
                        j.hp -= attack
                        if (j.hp <= 0) {
                            j.hp = 0
                        }
                        println("${j.name} wurde angegriffen und hat noch ${j.hp}")
                        minions.forEach {
                            print("|$c.${it.name} hat: ${it.hp}HP| ")
                            c++
                        }
                        println()
                    }
                    if (minions[0].hp == 0 && minions[1].hp == 0 && minions[2].hp == 0) {
                        enemy.minions = false
                    }
                    break
                }
                break
            } else {
                enemy.hp -= attack
                if (enemy.hp < 0) enemy.hp = 0
                println("${enemy.name} hat Schaden erlitten! HP:${enemy.hp}")
                break
            }
        }
        break
    }
}

fun enemyRound(myTeam: MutableList<Held>, enemy: Dragon, minions: MutableList<Gegner>) {
    while (true) {
        var j = (0 until myTeam.size).random()
        if (myTeam[j].hp > 0) {
            if (enemy.minions) {
                for (i in minions) {
                    if (i.hp > 0){
                    when (i.attack()) {
                        1 -> {
                            val held = myTeam.random()
                            println("${i.name} führt den Angriff 'Schubser' aus.")
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
                            println("${i.name} führt den Angriff 'Stockschlag' aus.")
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
                            println("${i.name} führt den Angriff 'Peitsche' aus.")
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
                            println("${i.name} führt den Angriff 'Steinwurf' aus.")
                            if (held.hp > 0 && !held.shield) {
                                held.hp -= 60
                                println("${held.name} HP: ${held.hp}")
                            } else if (held.shield) {
                                held.shield = false
                                println("${held.name} hatte ein Schild!")
                            } else println("Keinen getroffen...")
                        }
                    }}
                }
            }
            while (true) {
                j = (0 until myTeam.size).random()
                if (myTeam[j].hp > 0) {
                    when (enemy.attack()) {
                        1 -> {
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
                            myTeam.forEach {
                                if (it.hp > 0) {
                                    it.hp -= (40..60).random()
                                    println("${it.name} wurde getroffen! HP:${it.hp}")
                                }
                            }
                            break
                        }

                        5 -> {
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
                        6 -> break
                    }
                    break
                } else continue
            }
            break
        } else continue
    }
}

fun death(myTeam: MutableList<Held>, enemy: Dragon): Boolean {
    var dCount = 0
    for (i in myTeam)
        if (i.hp <= 0) {
            dCount++
        }

    if (enemy.hp <= 0) {
        println("\nDu hast ${enemy.name} vernichtet! Herzlichen Glückwunsch!")
        return true
    }

    if (dCount == 3) {
        println("\n${enemy.name} hat dein Team vernichtet!")
        return true
    }
    return false
}