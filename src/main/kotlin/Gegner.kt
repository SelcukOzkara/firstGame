open class Gegner(var name: String, var hp: Int) {

    open fun attack(myTeam: MutableList<Held>, minion: Gegner, enemy: Dragon){
    }

    override fun toString(): String {
       return "${this.name} + ${this.hp}"
    }
}