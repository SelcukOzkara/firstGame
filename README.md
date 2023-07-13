<img alt="Logo.png" src="Logo.png"/>

---
Hierbei handelt sich um ein kleines Spiel, 
in dem man mit einem selbst zusammengestellten Team
genen einen Drachen kämpft. Der Kampf ist runden basiert.


### <span style="color:gold"><center>Wie läuft das Spiel ab?</center></span>

---
Die Navigierung erfolgen über die Konsole, indem man durch die
Eingabe einer Zahl jeweils durch die Menüs navigiert. Du beginnst
damit dir ein Team aus jeweils 3 Helden verschiedener Klassen
(Ritter, Magier, Berserker) auszuwählen. Schon startet die erste
Runde und du kannst je Held in deinem Team eine Aktion ausführen.
Haben alle deine Helden eine Aktion durchgeführt ist der Drache dran.
Dieser greift je nach Skill eines deiner Helden an, beschwört Minions
oder greift alle Helden auf einmal an. Die Runden werden wiederholt
bis du den Drachen besiegst oder der Drache dein Team vernichtet.

### <span style="color:gold"><center>Klassendiagramme</center></span>

---
<details><summary>Klassen der Helden</summary>
<br>Die einzelnen Helden erben von der Oberklasse Held.
<img alt="Klassendiagramm_Held.png" src="Klassendiagramm_Held.png"/>  </details>
<details><summary>Klassen der Gegner</summary>
<br>Die einzelnen Gegner erben von der Oberklasse Gegner.
<img alt="Klassendiagramm_Gegner.png" src="Klassendiagramm_Gegner.png"/> </details>

### <span style="color:gold"><center>Skills & Stats</center></span>

---

### <span style="color:green">Helden</span>
*Der User hat die Möglichkeit jede Runde die Aktion für jeden einzelnen Helden zu setzen.*

###### Skills
<details>
<summary><u>Magier</u></summary>

* Feuersturm -> trifft ein Gegner mit einem random Schaden
* Spiralschlag -> trifft einen Gegner mit einem random Schaden
* Heilen -> Heilt alle aus dem Team inklusive sich <br>(Vorausgesetzt HP > 0)
* Schild -> erleidet kein Schaden | sobald getroffen = reset 

</details>


<details>
<summary><u>Ritter</u></summary>

* Schwerthieb -> trifft ein Gegner mit einem random Schaden
* Spiralschlag -> trifft ein Gegner mit einem random Schaden
* Fokus -> lädt einen Schlag +Damage beim nächsten Angriff
* Schild -> erleidet kein Schaden | sobald getroffen = reset

</details>

<details>
<summary><u>Berserker</u></summary>

* Hieb -> trifft ein Gegner mit einem random Schaden
* Tausend Dolche -> trifft ein Gegner mit einem random Schaden
* Fokus -> lädt einen Schlag +Damage beim nächsten Angriff
* Schild -> erleidet kein Schaden | sobald getroffen = reset
</details>

###### Stats

| Char      | HP  | Damage | 
|-----------|-----|--------|
| Berserker | 110 | 60-190 |
| Ritter    | 150 | 20-160 |
| Magier    | 100 | 30-90  |


### <span style="color:red">Gegner</span>
*Die Gegner greifen alle mit random Angriffen an, die jede Runde neu gesetzt werden.*

###### Skills
<details>
<summary><u>Drache</u></summary>

* Schwarze Flamme -> trifft einen Helden mit einem random Schaden
* Felswurf -> trifft einen Helden mit einem random Schaden
* Heilung -> heilt sich selbst
* Eisatem -> trifft alle Helden mit einem random Schaden
* Giftwolke -> trifft einen Helden, zieht solange 10% von maximalen HP ab, bis Held nur noch 20% vom maximalen HP hat
* Beschwörung -> beschwört 3 Minions (nur 1x pro Spiel möglich)
</details>

<details>
<summary><u>Minions</u></summary>

* Schubser -> trifft einen Helden mit einem random Schaden
* Stockschlag -> trifft einen Helden mit einem random Schaden
* Peitsche -> trifft einen Helden mit einem random Schaden
* Steinwurf -> trifft einen Helden mit einem random Schaden
</details>

###### Stats

| Char   | HP   | Damage | 
|--------|------|--------|
| Drache | 4000 | 40-120 |
| Minion | 800  | 5-60   |

