package com.bcit.lab4towaquimbayo

abstract class Mission(protected val minion: Minion) {
    fun start(listener: MissionListener) {
        listener.missionStart(minion)
        listener.missionProgress()
        listener.missionComplete(minion, reward(determineMissionTime()))
    }

    protected abstract fun determineMissionTime(): Int
    protected abstract fun reward(missionTime: Int): String
}