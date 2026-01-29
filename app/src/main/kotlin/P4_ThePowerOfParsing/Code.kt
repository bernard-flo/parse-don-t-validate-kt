package P4_ThePowerOfParsing

import P3_PayingItForward.NonEmpty


//////////////////////////////////////////////////////


suspend fun <T> validateNonEmpty(l: List<T>): Unit {
    if (l.isNotEmpty()) {
        return Unit
    } else {
        throw Exception("list cannot be empty")
    }
}

suspend fun <T> parseNonEmpty(l: List<T>): NonEmpty<T> {
    if (l.isNotEmpty()) {
        return NonEmpty(l[0], l.drop(1))
    } else {
        throw Exception("list cannot be empty")
    }
}
