fun startText(){
    println("""
        
   ▄██████▄   ▄██████▄   ▄█       ████████▄     ▄████████ ███▄▄▄▄           ▄████████ ▄██   ▄   ███▄▄▄▄       ███        ▄████████ ▀████    ▐████▀ 
  ███    ███ ███    ███ ███       ███   ▀███   ███    ███ ███▀▀▀██▄        ███    ███ ███   ██▄ ███▀▀▀██▄ ▀█████████▄   ███    ███   ███▌   ████▀  
  ███    █▀  ███    ███ ███       ███    ███   ███    █▀  ███   ███        ███    █▀  ███▄▄▄███ ███   ███    ▀███▀▀██   ███    ███    ███  ▐███    
 ▄███        ███    ███ ███       ███    ███  ▄███▄▄▄     ███   ███        ███        ▀▀▀▀▀▀███ ███   ███     ███   ▀   ███    ███    ▀███▄███▀    
▀▀███ ████▄  ███    ███ ███       ███    ███ ▀▀███▀▀▀     ███   ███      ▀███████████ ▄██   ███ ███   ███     ███     ▀███████████    ████▀██▄     
  ███    ███ ███    ███ ███       ███    ███   ███    █▄  ███   ███               ███ ███   ███ ███   ███     ███       ███    ███   ▐███  ▀███    
  ███    ███ ███    ███ ███▌    ▄ ███   ▄███   ███    ███ ███   ███         ▄█    ███ ███   ███ ███   ███     ███       ███    ███  ▄███     ███▄  
  ████████▀   ▀██████▀  █████▄▄██ ████████▀    ██████████  ▀█   █▀        ▄████████▀   ▀█████▀   ▀█   █▀     ▄████▀     ███    █▀  ████       ███▄ 
                        ▀                                                                                                                                                                                               
    """.trimIndent())
}

fun chooseTeam(): MutableList<Held>{
    val helden = mutableListOf<Held>()

    println("""
       ┌─────────────────────────────────┐
       │ Wähle drei Helden für dein Team │
       └─────────────────────────────────┘
       
        [1] ${Ritter("",0,0,0)}
        [2] ${Magier("",0,0,0)}
        [3] ${Berserker("",0,0,0)}
        
    """.trimIndent())

    var i = 0
    while (i < 3){
        try {
            val input = readln().toInt()
            if (input !in 1..3) throw Exception("")
            when (input){
                1 -> {
                    helden.add(Ritter("",0,0,0))
                    println("Der Ritter wurde erfolgreich in dein Team hinzugefügt!")
                }
                2 -> {
                    helden.add(Magier("",0,0,0))
                    println("Der Magier wurde erfolgreich in dein Team hinzugefügt!")
                }
                3 -> {
                    helden.add(Berserker("",0,0,0))
                    println("Der Berserker wurde erfolgreich in dein Team hinzugefügt!")
                }
            }
            i++
        } catch (e: Exception){
            println("Falsche eingabe!")
            continue
        }

    }
    return helden
}

