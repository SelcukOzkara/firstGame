class Magier:Held(name = "", hp = 0, damage = 0, armor = 0, shield = false){

    init {
        this.name = "Gandalf der Magier"
        this.hp = 100
        this.damage = 0
        this.armor = 40
    }

    override fun aktion(): Int{
        println("${this.name} ist an der Reihe!")
        println("HP: ${this.hp} | Schild: ${this.shield}")
        while (true){
            println("""
            
            [1] Feuersturm          [2] Hagelschauer
            [3] Heilen              [4] Schild
            
            Wählen Sie aus:
        """.trimIndent())
            try{
                val input = readln().toInt()
                if (input !in 1 .. 4 && input != 5) throw Exception("")

                when (input){
                    1 -> {
                        this.damage = attack(input)
                        return this.damage
                    }
                    2 -> {
                        this.damage = attack(input)
                        return this.damage
                    }
                    3 -> {
                        this.hp += (50..100).random()
                        return 0
                    }
                    4 -> {
                        this.shield = true
                        return 0
                    }
                }
                break
            }catch (e:Exception){
                println("Bitte wähle aus einen Angriff aus!")
            }
        }
        return 0
    }

    override fun toString(): String {
        return "Magier | Name: ${this.name} HP: ${this.hp} Armor: ${this.armor}"
    }

    override fun attack(angriff: Int): Int{
        return if (angriff == 1) (40..60).random()
        else (40..100).random()
    }

}