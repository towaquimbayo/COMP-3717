package com.bcit.lab4towaquimbayo

interface MissionListener {
    fun missionStart(minion: Minion)
    fun missionProgress(): Unit = println("...\n...\n...")
    fun missionComplete(minion: Minion, reward: String)
}