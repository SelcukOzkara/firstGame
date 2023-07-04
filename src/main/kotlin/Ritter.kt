class Ritter(name:String, hp:Int, damage: Int, armor: Int):Held(name, hp, damage, armor) {
    var focus = 0
    var shield = 0

    init {
        this.name = "Der dunkle Ritter"
        this.hp = 100
        this.damage = 0
        this.armor = 250
    }

    fun aktion(): Int{
        println("${this.name} ist an der Reihe!")
        while (true){
            println("""
            
            [1] Schwerthieb         [2] Spiralschlag
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
        return "Ritter | Name: ${this.name} HP: ${this.hp} Armor: ${this.armor}"
    }

    override fun attack(angriff: Int): Int{
        return if (angriff == 1) (20..60).random()
        else (40..90).random()
    }
}