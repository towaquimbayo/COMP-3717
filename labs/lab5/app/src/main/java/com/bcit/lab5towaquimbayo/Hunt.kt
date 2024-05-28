package com.bcit.lab5towaquimbayo

import kotlin.properties.Delegates
import kotlin.random.Random

class Hunt(minion: Minion, itemToBring: Item? = null) : Mission(minion, itemToBring), Repeatable {
    override var repeatNum: Int by Delegates.vetoable(3) { _, _, newRepeat ->
        newRepeat in 1..3
    }

    override fun determineMissionTime(): Int {
        return (minion.backpackSize + minion.baseSpeed + (item?.timeModifier
            ?: 0)) * Random.nextInt(0, 5)
    }

    override fun reward(missionTime: Int): String {
        return if (minion is Elf) {
            minion.huntReward(missionTime)
        } else {
            when (missionTime) {
                in 11..20 -> "mouse"
                in 21..30 -> "fox"
                in 31..40 -> "buffalo"
                in 41..60 -> "dinosaur"
                else -> "nothing"
            }
        }
    }

    override fun repeat(repeat: Int, listener: MissionListener) {
        repeatNum = repeat
        if (repeat in 1..3) println("Repeating a hunt $repeatNum time(s)...\n")
        else println("A minion cannot repeat a hunt more than $repeatNum times! Repeating a hunt $repeatNum times...\n")
        for (i in 1..repeatNum) start(listener)
    }
}