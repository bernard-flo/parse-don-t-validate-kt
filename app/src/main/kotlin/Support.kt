sealed interface Maybe<out T> {
    data class Just<T>(val value: T) : Maybe<T>
    object Nothing : Maybe<kotlin.Nothing>

    fun <R> fmap(f: (T) -> R): Maybe<R> {
        return when (this) {
            is Just -> Just(f(this.value))
            is Nothing -> Nothing
        }
    }
}


typealias FilePath = String


suspend fun getEnv(key: String): String {
    TODO()
}


fun initializeCache(cacheDir: FilePath) {
    TODO()
}
