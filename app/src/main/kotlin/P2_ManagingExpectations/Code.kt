package P2_ManagingExpectations

import FilePath
import Maybe
import Maybe.Just
import Maybe.Nothing
import getEnv
import initializeCache
import java.util.*


//////////////////////////////////////////////////////


object i {

    fun <T> head(l: List<T>): Maybe<T> {
        TODO()
    }

    fun <T> head_Optional(l: List<T>): Optional<T> {
        TODO()
    }

    fun <T> head_Nullable(l: List<T>): T? {
        TODO()
    }

}


//////////////////////////////////////////////////////


fun <T> head(l: List<T>): Maybe<T> {
    if (l.isNotEmpty()) {
        return Just(l[0])
    } else {
        return Nothing
    }
}


//////////////////////////////////////////////////////


suspend fun getConfigurationDirectories(): List<FilePath> {
    val configDirsString = getEnv("CONFIG_DIRS")
    val configDirsList = configDirsString.split(",")
    if (configDirsList.isEmpty()) {
        throw Exception("CONFIG_DIRS cannot be empty")
    }
    return configDirsList
}

suspend fun main() {
    val configDirs = getConfigurationDirectories()
    when (val it = head(configDirs)) {
        is Just -> initializeCache(it.value)
        is Nothing -> throw Exception("should never happen; already checked configDirs is non-empty")
    }
}
