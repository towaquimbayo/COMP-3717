package com.bcit.lab4towaquimbayo

class Archer(
    override val race: String = "Archer",
    override val baseHealth: Int = 2,
    override val baseSpeed: Int = 8,
    override val backpackSize: Int = 3,
    override val catchphrase: String = "My arrows never miss!"
) : Minion()