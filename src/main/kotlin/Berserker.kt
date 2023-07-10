class Berserker:Held(name = "",maxHp = 0, hp = 0, damage = 0, shield = false, isPoison = false){
    var focus = false

    init {
        this.name = "Bero der Berserker"
        this.maxHp = 110
        this.hp = maxHp
        this.damage = 0
    }

    override fun aktion(): Int{
        println("\n${this.name} ist an der Reihe!")
        println("HP: ${this.hp} | Schild: ${this.shield}")
        while (true){
            println("""
            
            [1] Hieb                [2] Tausend Dolche
            [3] Fokus               [4] Schild
            
            [5] Beutel
            
            Wählen Sie aus:
        """.trimIndent())
            try{
                val input = readln().toInt()
                if (input !in 1 .. 5 ) throw Exception("")

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
                    5 -> return -2
                }
                break
            }catch (e:Exception){
                println("Bitte wähle aus einen Angriff aus!")
            }
        }
        return 0
    }

    override fun toString(): String {
        return "Berserker | Name: ${this.name} HP: ${this.hp}"
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