package education.cccp.tp11listview.repositories

import education.cccp.tp11listview.models.Person

object PersonDao {
    private val persons = mutableListOf<Person>()

    @Throws(Exception::class)
    fun save(person: Person): Person = if (persons.add(person)) person
    else throw Exception("malformed exception : $person")

    fun save(
        index: Int,
        person: Person
    ): Person = persons.set(index, person)

    fun delete(index: Int) {
        persons.removeAt(index)
    }

    fun findAll(): List<Person> = persons
}