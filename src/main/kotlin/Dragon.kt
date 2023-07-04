class Dragon{
    var name = "Black Dragon"
    var hp = 500
    var damage = (70..120).random()
    var armor = 250
    var heal = 0

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
                this.heal += 50
                println("${this.name} heilt sich.")
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