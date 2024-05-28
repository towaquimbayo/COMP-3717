package com.bcit.lab1towaquimbayo

/*
    Towa Quimbayo
    A01086002
 */
const val VERSION_NUM:Double = 0.2
const val SLOGAN:String = "deliver with a smile"
fun main() {
    val streetNum = 123
    val streetName = "loch ness road"
    val fullAddress:String? = if (VERSION_NUM >= 1) "$streetNum ${streetName}, glasgow, scotland" else null
    val message:String = """
    %s
            Food Delivery Service v$VERSION_NUM

    Welcome to Glasgow's finest food delivery service, where we provide
    you with swift instructions on where to deliver your food.

            Please deliver the food to:

            ${fullAddress?.uppercase()}

    Your hard work and commitment to delivering food are
    always appreciated, and never forget..${SLOGAN.uppercase()}.

    ...Thank you.
    """.trimIndent()
    print(message.format(if (fullAddress === null) "Starting beta version...\n...\n...\n...\n" else ""))
}