package mastermind

import java.lang.StringBuilder

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun countRightPositions(secret: StringBuilder, guess: StringBuilder): Int{

    var count = 0

    for (i in 3 downTo  0) {
        if (guess[i] == secret[i]){
            count++
            secret.deleteCharAt(i)
            guess.deleteCharAt(i)
        }
    }

    return count
}


fun countWrongPositions(secret: StringBuilder, guess: StringBuilder): Int{

    var count = 0

    for (ch in guess) {
        if (ch in secret){
            count++
            secret.deleteCharAt(secret.indexOf(ch))
        }
    }

    return count
}


@OptIn(ExperimentalStdlibApi::class)
fun evaluateGuess(secret: String, guess: String): Evaluation {
    val secretCopy = StringBuilder(secret)
    val guessCopy = StringBuilder(guess)
    return Evaluation(countRightPositions(secretCopy, guessCopy), countWrongPositions(secretCopy, guessCopy))
}

