class Berserker:Held(name = "", hp = 0, damage = 0, armor = 0, shield = false){
    var focus = false

    init {
        this.name = "Bero der Berserker"
        this.hp = 100
        this.damage = 0
        this.armor = 100
    }

    override fun aktion(): Int{
        println("${this.name} ist an der Reihe!")
        println("HP: ${this.hp} | Schild: ${this.shield}")
        while (true){
            println("""
            
            [1] Hieb                [2] Tausend Dolche
            [3] Fokus               [4] Schild
            
            Wählen Sie aus:
        """.trimIndent())
            try{
                val input = readln().toInt()
                if (input !in 1 .. 4 && input != 5) throw Exception("")

                when (input){
                    1 -> {
                        this.damage += attack(input)
                        return this.damage
                    }
                    2 -> {
                        this.damage += attack(input)
                        return this.damage
                    }
                    3 -> {
                        this.focus = true
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
        return "Berserker | Name: ${this.name} HP: ${this.hp} Armor: ${this.armor}"
    }

    override fun attack(angriff: Int): Int{
        if (this.focus){
            if (angriff == 1){
                this.focus = false
                return (20..60).random() + 100
            } else if (angriff == 2){
                this.focus = false
                return (40..90).random() + 100
            }
        } else {
            if (angriff == 1){
                return (20..60).random() + 100
            } else if (angriff == 2){
                return (40..90).random() + 100
            }
        }
        return 0
    }
}