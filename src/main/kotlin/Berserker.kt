class Berserker(name:String, hp:Int, damage: Int, armor: Int):Held(name, hp, damage, armor){
    var shield = 0
    var focus = 0

    init {
        this.name = "Bero der Berserker"
        this.hp = 100
        this.damage = 0
        this.armor = 100
    }

    fun aktion(): Int{
        println("${this.name} ist an der Reihe!")
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
                        this.damage += attack(input) + this.focus
                        this.focus = 0
                        return this.damage
                    }
                    2 -> {
                        this.damage += attack(input) + this.focus
                        this.focus = 0
                        return this.damage
                    }
                    3 -> {
                        this.focus = 0
                        this.focus += 50
                        return 0
                    }
                    4 -> {
                        this.shield = 0
                        this.shield + 1
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
        return if (angriff == 1) (50..90).random()
        else (80..120).random()
    }
}