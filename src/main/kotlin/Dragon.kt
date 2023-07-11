class Dragon: Gegner(name = "", hp = 100){
    var minions = false
    var i = mutableListOf(1,1,1,1,2,2,2,2,3,3,3,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,6,6)
    init {
        this.name = "Black Dragon"
        this.hp = 4000
    }

    override fun attack(): Int{
        when (i.random()){
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
                return 0
            }
            4 -> {
                println("${this.name} führt den Angriff 'Eisatem' aus.")
                return -1
            }
            5 -> {
                println("${this.name} führt den Angriff 'Giftwolke' aus.")
                return -2
            }
            6 -> {
                this.minions = true
                println("${this.name} hat drei Minions beschworen.")
                i.removeAll { it == 6 }
                return -3
            }
        }
        return 0
    }
}