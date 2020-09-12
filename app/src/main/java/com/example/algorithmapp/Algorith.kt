package com.example.algorithmapp

import java.util.*

fun removeBackSpace(text: String, text2: String): Boolean {
    val charStack1 = Stack<Char>()
    val charStack2 = Stack<Char>()
    pushChar(text, charStack1)
    pushChar(text2, charStack2)
    return charStack1.toString() == charStack2.toString()
}

/**
 * Function pushes char to stack if it is not '#' and it is '#' the it is pops the stack which
 * removes top element
 */
fun pushChar(text: String, charStack: Stack<Char>){
    for (letter in text) {
        if (letter != '#') {
            charStack.push(letter)
        } else if (charStack.isEmpty().not() && letter == '#') {
            charStack.pop()
        }
    }
}

fun main() {
    val text1 = removeBackSpace("ab##c","a#d#c")
    println(text1)
}