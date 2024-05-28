package com.bcit.lab5towaquimbayo

class Elf(
    override val race: String = "Elf",
    override val baseHealth: Int = 2,
    override val baseSpeed: Int = 8,
    override val backpackSize: Int = 3,
    override val catchphrase: String = "My arrows never miss!"
) : Minion {
    fun huntReward(missionTime: Int): String {
        return when (missionTime) {
            in 11..20 -> "fish"
            in 21..30 -> "forest bear"
            in 31..40 -> "orc"
            in 41..60 -> "troll"
            else -> "nothing"
        }
    }
}