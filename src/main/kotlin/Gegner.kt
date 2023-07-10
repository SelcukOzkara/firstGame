open class Gegner(var name: String, var hp: Int) {

    open fun attack(): Int{
        return 0
    }

    override fun toString(): String {
       return "${this.name} + ${this.hp}"
    }
}