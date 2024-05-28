package com.bcit.lab5towaquimbayo

abstract class Mission(protected val minion: Minion, protected val item: Item? = null) {
    fun start(listener: MissionListener) {
        listener.missionStart(minion)
        listener.missionProgress()
        listener.missionComplete(minion, reward(determineMissionTime()))
    }

    protected abstract fun determineMissionTime(): Int
    protected abstract fun reward(missionTime: Int): String
}