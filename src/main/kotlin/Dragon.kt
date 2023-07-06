class Dragon{
    var name = "Black Dragon"
    var hp = 2000
    var damage = (70..120).random()
    var armor = 250

    fun attack(): Int{
        var i = listOf(1,1,1,1,2,2,2,2,3,3,4)

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
                return (50..90).random()
            }
        }
        return 0
    }
}