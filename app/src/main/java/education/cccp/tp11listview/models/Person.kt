package education.cccp.tp11listview.models

import java.io.Serializable

data class Person(
    val id: Int = idGenerator(),
    val firstName: String,
    val lastName: String
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
        var counter = 0
        fun idGenerator() = ++counter
    }
}