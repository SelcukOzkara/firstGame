package Items

class Heal: Item(name = "Heiltrank", beschreibung = "Heilt einen deiner Helden mit 50 HP", anzahl = 3) {
    var heal = 50

    override fun toString(): String {
        return "${this.name}: ${this.beschreibung} | Anzahl: ${this.anzahl}"
    }
}