package P3_PayingItForward

import FilePath
import Maybe
import Maybe.Just
import Maybe.Nothing
import getEnv
import initializeCache


//////////////////////////////////////////////////////


fun <T> head(l: List<T>): T {
    TODO()
}


//////////////////////////////////////////////////////


data class NonEmpty<T>(
    val head: T,
    val tail: List<T>,
)


//////////////////////////////////////////////////////


fun <T> head(l: NonEmpty<T>): T {
    return l.head
}


//////////////////////////////////////////////////////


suspend fun getConfigurationDirectories(): NonEmpty<FilePath> {
    val configDirsString = getEnv("CONFIG_DIRS")
    val configDirsList = configDirsString.split(",")
    when (val it = nonEmpty(configDirsList)) {
        is Just -> return it.value
        is Nothing -> throw Exception("CONFIG_DIRS cannot be empty")
    }
}

suspend fun main() {
    val configDirs = getConfigurationDirectories()
    initializeCache(head(configDirs))
}


//////////////////////////////////////////////////////


fun <T> nonEmpty(l: List<T>): Maybe<NonEmpty<T>> {
    TODO()
}


//////////////////////////////////////////////////////


fun <T> head_(l: List<T>): Maybe<T> {
    return nonEmpty(l).fmap(::head)
}
