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
                println("${this.name} führt den Angriff 'Schwarze Flamme' aus.")
                return (40..120).random()
            }

            2 -> {
                println("${this.name} führt den Angriff 'Felswurf' aus.")
                return (50..60).random()
            }

            3 -> {
                this.hp += (200..500).random()
                println("${this.name} heilt sich und hat jetzt wieder ${this.hp} HP.")
                return 1
            }

            4 -> {
                println("${this.name} führt den Angriff 'Eisatem' aus.")
                return -1
            }
        }
        return 0
    }
}