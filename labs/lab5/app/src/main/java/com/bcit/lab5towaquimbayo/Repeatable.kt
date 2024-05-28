package com.bcit.lab5towaquimbayo

interface Repeatable {
    val repeatNum: Int
    fun repeat(repeat: Int, listener: MissionListener): Unit
}