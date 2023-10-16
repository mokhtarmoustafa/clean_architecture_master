package com.cct.cleanarchitecturedemo.tring


typealias MyInt=Int
class DemoTest {

    val myInt:MyInt=10
}

fun main() {
    val trimmedString="""HI my name is
        |Mokhtar
        |Im rellay happy to share this data
    """.trimMargin()

    println(trimmedString)
}