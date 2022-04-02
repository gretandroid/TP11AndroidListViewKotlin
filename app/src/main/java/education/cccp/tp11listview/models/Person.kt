package education.cccp.tp11listview.models

data class Person(
    val id: Int = idGenerator(),
    val firstName: String,
    val lastName: String
) {
    companion object {
        var counter = 0
        fun idGenerator() = ++counter
    }
}