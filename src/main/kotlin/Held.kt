open class Held(var name: String, var hp: Int, var damage: Int,var armor: Int){


    open fun attack(angriff: Int): Int{
        return 0
    }

    override fun toString(): String {
        return "Name: ${this.name} HP: ${this.hp} Armor: ${this.armor}"
    }
}