package com.bcit.lab4towaquimbayo

/**
 * Towa Quimbayo
 * A01086002
 */
fun main() {
    val dwarf = Dwarf()
    val archer = Archer("Elf")
    val gatherMission = Gather(dwarf)
    val huntMission = Hunt(archer)

    val missionListener = object : MissionListener {
        var missionType = "Gather"

        override fun missionStart(minion: Minion) {
            println(minion.catchphrase)
            if (missionType == "Gather") {
                println("\nA ${minion.race} was sent off to gather some resources!")
            } else {
                println("\nA ${minion.race} started a new hunt!")
            }
        }

        override fun missionComplete(minion: Minion, reward: String) {
            if (missionType == "Gather") {
                println("A ${minion.race} has returned from gathering, and found $reward!\n")
            } else {
                println("A ${minion.race} has returned from a hunt, and found $reward!\n")
            }
        }
    }

    gatherMission.start(missionListener)
    missionListener.missionType = "Hunt"
    huntMission.repeat(2, missionListener)
}