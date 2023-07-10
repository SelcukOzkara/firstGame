class Reviv: Item("Wiederbelebung", "Kann einen verstorbenen Helde wiederbeleben",1) {
    override fun toString(): String {
        return "${this.name}: ${this.beschreibung} | Anzahl: ${this.anzahl}\n"
    }
}