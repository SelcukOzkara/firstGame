package Utils

import Gegner.Dragon
import Gegner.Gegner
import Gegner.Minions
import Helden.Berserker
import Helden.Held
import Helden.Magier
import Helden.Ritter
import Items.Heal
import Items.Item
import Items.Reviv

var cReset = "\u001B[0m"
var cRed = "\u001B[31m"
var cGreen = "\u001B[32m"
var cYellow = "\u001B[33m"

//Ausgabe vom ASCII Code | Generiert über http://www.network-science.de/ascii/
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

// Funktion für die Auswahl des Teams von Helden
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

// Funktion zur Erstellung der Minions
fun createMinions(): MutableList<Gegner> {
    return mutableListOf(Minions(), Minions(), Minions())
}

// Funktion zur Erstellung des Beutels/Inventars mit den vorgegebenen Tränken
fun createBeutel(): MutableList<Item> {
    return mutableListOf(Heal(), Reviv())
}

// Funktion, um den Kampf zu starten, Aufruf verschiedenen Funktionen
fun battle(myTeam: MutableList<Held>, myBeutel: MutableList<Item>, enemy: Dragon, minions: MutableList<Gegner>) {
    while (!death(myTeam, enemy)) {
        println("\n${cGreen}In deinem Team leben noch:$cReset")
        for (i in myTeam) {
            if (i.hp > 0) {
                println(
                    """
                ${i.name} mit $cRed${i.hp}$cReset HP
            """.trimIndent()
                )
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

// Funktion überprüft ob Held Vergiftet ist
fun checkPoison(i: Held) {
    if (i.isPoison && i.hp > (i.maxHp * 0.2).toInt()) {
        i.hp -= (i.maxHp * 0.1).toInt()
    } else if (i.isPoison && i.hp <= (i.maxHp * 0.2).toInt()) {
        i.isPoison = false
    }
}

// Funktion für die Aktionen der Helden
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
            println(
                """
                
                $cGreen++++++++++++++++++++++++++++++++++++
                ++++++++++++++++++Heilung...+++++++++++++++$cReset
            """.trimIndent()
            )
            myTeam.forEach {
                if (it.hp > 0) {
                    if (it.hp < it.maxHp){
                        it.hp += 35
                        if (it.hp > it.maxHp){
                            it.hp = it.maxHp
                        }
                        println("${it.name} | $cRed${it.hp}$cReset HP")
                    }
                }
            }
            println(
                """
                $cGreen++++++++++++++++++++++++++++++++++++$cReset
                
            """.trimIndent()
            )
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
                            if (i.hp < i.maxHp){
                                myBeutel[0].anzahl -= 1
                                i.hp += 50
                                if (i.hp > i.maxHp){
                                    i.hp = i.maxHp
                                }
                                check = 1
                                break
                            } else {
                                println("Du hast volle HP!")
                                break
                            }
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
                        println("""
                            
                            ${j.name} wurde angegriffen und hat noch $cRed${j.hp}$cReset
                        
                        """.trimIndent())
                        minions.forEach {
                            println("""
                                (ง ͠ ᵒ̌ Дᵒ̌ )▬▬ι═══════ﺤ
                                |$c.${it.name} hat: $cRed${it.hp}$cReset HP|
                                
                            """.trimIndent())
                            c++
                        }
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
                println("${enemy.name} hat Schaden erlitten! HP:$cRed${enemy.hp}$cReset")
                break
            }
        }
    }
}

// Funktion für die Aktionen der Gegner (Minions & Drachen)
fun enemyRound(myTeam: MutableList<Held>, enemy: Dragon, minions: MutableList<Gegner>) {
    minions.forEach { it.attack(myTeam, it, enemy) }
    enemy.attack(myTeam, minions.random(), enemy)
}

// Funktion zur Überpüfung, ob die Helden oder der Drache besiegt wurde.
fun death(myTeam: MutableList<Held>, enemy: Dragon): Boolean {
    var dCount = 0
    for (i in myTeam)
        if (i.hp <= 0) {
            dCount++
        }

    if (enemy.hp <= 0) {
        println("\n${cGreen}Du hast ${enemy.name} vernichtet! Herzlichen Glückwunsch!$cReset")
        return true
    }

    if (dCount == 3) {
        println("\n$cRed${enemy.name} hat dein Team vernichtet!$cReset")
        return true
    }
    return false
}