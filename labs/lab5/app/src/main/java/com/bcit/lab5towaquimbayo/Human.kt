package com.bcit.lab5towaquimbayo

class Human(
    override val race: String = "Human",
    override val baseHealth: Int = 5,
    override val baseSpeed: Int = 5,
    override val backpackSize: Int = 5,
    override val catchphrase: String = ""
) : Minion