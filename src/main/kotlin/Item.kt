open class Item (var name: String, var beschreibung: String, var anzahl: Int) {

    override fun toString(): String {
        return "${this.name}: ${this.beschreibung} | Anzahl: ${this.anzahl}\n"
    }
}