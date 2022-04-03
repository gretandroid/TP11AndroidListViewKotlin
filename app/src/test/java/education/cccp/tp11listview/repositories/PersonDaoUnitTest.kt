package education.cccp.tp11listview.repositories

import education.cccp.tp11listview.models.Person
import education.cccp.tp11listview.models.Person.Companion.PERSON_ID_DEFAULT_VALUE
import education.cccp.tp11listview.repositories.PersonDao.delete
import education.cccp.tp11listview.repositories.PersonDao.findAll
import education.cccp.tp11listview.repositories.PersonDao.idGenerator
import education.cccp.tp11listview.repositories.PersonDao.save
import org.junit.Assert.*
import org.junit.Test


class PersonDaoUnitTest {


    companion object {
        fun printAll() = println(findAll())
    }

    private val person = Person(
        firstName = "john",
        lastName = "Doe"
    )

    @Test
    fun `test idGenerator`() {
        assertTrue(
            person.copy(id = idGenerator())
                .id > PERSON_ID_DEFAULT_VALUE
        )
    }

    @Test
    fun `test save une person sans id`() {
        assertEquals(person.id, PERSON_ID_DEFAULT_VALUE)
        assertTrue(save(person).id > PERSON_ID_DEFAULT_VALUE)
    }

    @Test
    @Suppress("NonAsciiCharacters")
    fun `test mise à jour de la person à la dernière position`() {
        save(person.copy())
        assertEquals(findAll().last().firstName, person.firstName)
        val newFirstName = "Jane"
        val countBeforeSave = findAll().size
        save(findAll().size - 1, findAll().last().copy(firstName = newFirstName))
        assertEquals(countBeforeSave, findAll().size)
        assertNotEquals(findAll().last().firstName, person.firstName)
    }

    @Test
    fun `test supprimer une person`() {
        save(person.copy())
        assert(findAll().isNotEmpty())
        val countBeforeDelete = findAll().size
        delete(findAll().size - 1)
        assertEquals(countBeforeDelete - 1, findAll().size)
    }
}