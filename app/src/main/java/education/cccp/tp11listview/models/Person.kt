package education.cccp.tp11listview.models

import java.io.Serializable

data class Person(
    val id: Int = PERSON_DEFAULT_ID_VALUE,
    val firstName: String,
    val lastName: String
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
        const val PERSON_DEFAULT_ID_VALUE = -1
    }
}