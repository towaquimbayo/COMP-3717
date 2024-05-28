package com.bcit.lab4towaquimbayo

import kotlin.random.Random

class Gather(minion: Minion) : Mission(minion), Repeatable {
    override fun determineMissionTime(): Int {
        return minion.backpackSize * minion.baseSpeed * Random.nextInt(0, 5)
    }

    override fun reward(missionTime: Int): String {
        return when (missionTime) {
            in 10..21 -> "bronze"
            in 22..33 -> "silver"
            in 34..50 -> "gold"
            else -> "nothing"
        }
    }

    override fun repeat(count: Int, listener: MissionListener) {
        for (i in 1..count) start(listener)
    }
}