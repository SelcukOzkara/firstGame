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
        when (i.random()) {
            1 -> {
                println("${this.name} führt den Angriff 'Schubser' aus.")
                return 1
            }

            2 -> {
                println("${this.name} führt den Angriff 'Stockschlag' aus.")
                return 2
            }

            3 -> {
                println("${this.name} führt den Angriff 'Peitsche' aus.")
                return 3
            }

            4 -> {
                println("${this.name} führt den Angriff 'Steinwurf' aus.")
                return -4
            }
        }
        return 0
    }
}