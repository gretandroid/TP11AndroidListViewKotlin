package education.cccp.tp11listview.dao

import education.cccp.tp11listview.model.Person

object PersonDao {
    private var counter = 0

    @JvmStatic
    private val persons = mutableListOf<Person>()

    @JvmStatic
    fun idGenerator() = ++counter

    @JvmStatic
    @Throws(Exception::class)
    fun save(person: Person): Person =
        if (persons.add(person.copy(id = idGenerator()))) persons.last()
        else throw Exception("malformed exception : $person")

    @JvmStatic
    fun save(
        index: Int,
        person: Person
    ): Person = persons.set(index, person)

    @JvmStatic
    fun delete(index: Int) = persons.run {
        if (size > index) removeAt(index)
    }

    @JvmStatic
    fun findAll(): List<Person> = persons
}