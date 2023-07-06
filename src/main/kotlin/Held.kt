open class Held(var name: String, var hp: Int, var damage: Int,var armor: Int, var shield: Boolean){


    open fun attack(angriff: Int): Int{
        return if (angriff == 1) (40..60).random()
        else (40..100).random()
    }

    open fun aktion(): Int{
        return 0
    }


    override fun toString(): String {
        return "Name: ${this.name} HP: ${this.hp} Armor: ${this.armor}"
    }
}