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
                    println("Der Ritter wurde erfolgreich in dein Team hinzugefügt!")
                }

                2 -> {
                    helden.add(Magier())
                    println("Der Magier wurde erfolgreich in dein Team hinzugefügt!")
                }

                3 -> {
                    helden.add(Berserker())
                    println("Der Berserker wurde erfolgreich in dein Team hinzugefügt!")
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

fun battle(myTeam: MutableList<Held>, enemy: Dragon) {
    while (!death(myTeam, enemy)) {
        for (i in myTeam) {
            if (i.hp > 0 && enemy.hp > 0) {
                enemy.hp -= myTeam[myTeam.indexOf(i)].aktion()
                println(enemy.hp)
            } else continue
        }

        if (!death(myTeam, enemy)) {
            while (true) {
                val j = (0 until myTeam.size).random()
                if (myTeam[j].hp > 0) {
                    if (myTeam[j].shield){
                        myTeam[j].shield = false
                        println("${myTeam[j].name} hatte ein Schild!")
                        break
                    }else{
                        myTeam[j].hp -= enemy.attack()
                        println(myTeam[j].name + myTeam[j].hp)
                        break
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
            println("Du hast ${enemy.name} vernichtet! Herzlichen Glückwunsch!")
            return true
        }

        if (dCount == 3) {
            println("${enemy.name} hat dein Team vernichtet!")
            return true
        }
    return false
}