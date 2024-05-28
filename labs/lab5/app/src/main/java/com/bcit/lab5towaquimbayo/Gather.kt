package com.bcit.lab5towaquimbayo

import kotlin.random.Random

class Gather(minion: Minion, itemToBring: Item? = null) : Mission(minion, itemToBring) {
    override fun determineMissionTime(): Int {
        return (minion.backpackSize + minion.baseSpeed + (item?.timeModifier
            ?: 0)) * Random.nextInt(0, 5)
    }

    override fun reward(missionTime: Int): String {
        return when (missionTime) {
            in 10..21 -> "bronze"
            in 22..33 -> "silver"
            in 34..44 -> "gold"
            in 45..60 -> "diamond"
            else -> "nothing"
        }
    }
}