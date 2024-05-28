package com.bcit.lab5towaquimbayo

class Dwarf(
    override val race: String = "Dwarf",
    override val baseHealth: Int = 8,
    override val baseSpeed: Int = 2,
    override val backpackSize: Int = 8,
    override val catchphrase: String = "Wheres' me trusty ol hammer?"
) : Minion