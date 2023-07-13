package Helden

//Offene Oberklasse der Helden
open class Held(var name: String,var maxHp: Int, var hp: Int, var damage: Int, var shield: Boolean, var isPoison: Boolean){

    open fun attack(angriff: Int): Int{
        return if (angriff == 1) (40..60).random()
        else (40..100).random()
    }

    open fun aktion(): Int{
        return 0
    }


    override fun toString(): String {
        return "Name: ${this.name} HP: ${this.hp}"
    }
}