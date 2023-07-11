class Minions:Gegner(name = "", hp = 0) {
    init {
        this.name = "Minion"
        this.hp = 800
    }

    override fun toString():String{
        return "${this.name} + ${this.hp}"
    }
    override fun attack(): Int {
        var i = mutableListOf(1, 1, 1, 1, 2, 2, 2, 3, 3, 4)
        return i.random()
    }
}