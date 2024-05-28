package com.bcit.lab4towaquimbayo

import kotlin.random.Random

class Hunt(minion: Minion) : Mission(minion), Repeatable {
    override fun determineMissionTime(): Int {
        return minion.baseHealth * minion.baseSpeed * Random.nextInt(0, 5)
    }

    override fun reward(missionTime: Int): String {
        return when (missionTime) {
            in 11..20 -> "mouse"
            in 21..30 -> "fox"
            in 31..50 -> "buffalo"
            else -> "nothing"
        }
    }

    override fun repeat(count: Int, listener: MissionListener) {
        for (i in 1..count) start(listener)
    }
}