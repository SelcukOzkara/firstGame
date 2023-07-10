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
                    println("Der Ritter wurde erfolgreich in dein Team hinzugefügt!\n")
                }

                2 -> {
                    helden.add(Magier())
                    println("Der Magier wurde erfolgreich in dein Team hinzugefügt!\n")
                }

                3 -> {
                    helden.add(Berserker())
                    println("Der Berserker wurde erfolgreich in dein Team hinzugefügt!\n")
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

fun createMinions(): MutableList<Gegner>{
    return mutableListOf(Minions(),Minions(),Minions())
}

fun createBeutel(): MutableList<Item> {
    return mutableListOf(Heal(), Reviv())
}

fun battle(myTeam: MutableList<Held>, myBeutel: MutableList<Item>, enemy: Dragon, minions: MutableList<Gegner>) {
    while (!death(myTeam, enemy)) {
        for (i in myTeam) {
            if (i.hp > 0 && enemy.hp > 0) {
                if (i.isPoison && i.hp >= (i.maxHp*0.2).toInt()){
                    i.hp -= (i.maxHp * 0.1).toInt()
                } else if (i.isPoison && i.hp <= (i.maxHp*0.2).toInt()) {
                    i.isPoison = false
                }
                while (true){
                    var check = 0
                    var attack = myTeam[myTeam.indexOf(i)].aktion()
                    if (attack == -1) {
                        myTeam.forEach {
                            it.hp += 50
                            println("${it.name} wurde geheilt und hat nun ${it.hp} HP")
                        }
                        break
                    } else if (attack == -2) {
                        while (true) {
                            println("""
                            
                            [1] ${myBeutel[0]}
                            [2] ${myBeutel[1]}
                            
                            [0] Abbrechen 
                            
                        """.trimIndent())
                            try {
                                val input = readln().toInt()
                                if (input !in 1 .. myBeutel.size && input != 0) throw Exception("")

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
                                        for (j in myTeam){
                                            if (j.hp == 0) toteHelden.add(j)
                                        }
                                        if (myBeutel[1].anzahl <= 0) throw Exception("Du hast keinen Trank mehr!")
                                        if (toteHelden.isNotEmpty()){
                                            toteHelden.forEach { println(it) }
                                            println("Welchen Helden möchtest du wiederbeleben? 1-${toteHelden.size}")
                                            toteHelden[readln().toInt()-1].hp = 100
                                            myBeutel[1].anzahl -= 1
                                            check = 1
                                        }else println("Alle deine Helden leben noch!")
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
                        if (enemy.minions){
                                for (i in minions){
                                    if (i.hp > 0){
                                        i.hp -= attack
                                        if (i.hp <= 0){
                                            i.hp = 0
                                        }
                                        println("${i.name} wurde angegriffen und hat noch ${i.hp}")
                                        minions.forEach { println(it) }
                                        if (minions[0].hp <= 0 && minions[1].hp <= 0 && minions[2].hp <= 0){
                                            enemy.minions = false
                                            break
                                        }
                                        break
                                }
                            }
                        } else{
                            enemy.hp -= attack
                            if (enemy.hp < 0) enemy.hp = 0
                            println("${enemy.name} hat Schaden erlitten! HP:${enemy.hp}")
                            break
                        }
                    }
                }

            } else continue
        }

        if (!death(myTeam, enemy)) {
            while (true) {
                val j = (0 until myTeam.size).random()
                if (myTeam[j].hp > 0) {
                    if (myTeam[j].shield) {
                        myTeam[j].shield = false
                        println("${myTeam[j].name} hatte ein Schild!")
                        break
                    } else {
                        var attack = enemy.attack()
                        if (attack == -1) {
                            myTeam.forEach { it.hp -= (40..60).random() }
                            break
                        } else if (attack == -2) {
                            myTeam[j].isPoison = true
                            println("${myTeam[j].name} wurde vergiftet! HP: ${myTeam[j].hp}")
                            break
                        } else if (attack == 0){
                           break
                        }else {
                            myTeam[j].hp -= attack
                            if (myTeam[j].hp < 0) myTeam[j].hp = 0
                            println("${myTeam[j].name} wurde angegriffen! HP: ${myTeam[j].hp}")
                            break
                        }
                    }
                } else continue
            }
        }
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