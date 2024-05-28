package com.bcit.lab5towaquimbayo

interface MissionListener {
    fun missionStart(minion: Minion)
    fun missionProgress(): Unit = println("...\n...\n...")
    fun missionComplete(minion: Minion, reward: String)
}