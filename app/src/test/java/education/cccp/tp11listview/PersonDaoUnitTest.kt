package education.cccp.tp11listview

import education.cccp.tp11listview.models.Person
import education.cccp.tp11listview.models.Person.Companion.PERSON_DEFAULT_ID_VALUE
import education.cccp.tp11listview.repositories.PersonDao.findAll
import education.cccp.tp11listview.repositories.PersonDao.idGenerator
import education.cccp.tp11listview.repositories.PersonDao.save
import org.junit.Assert.*
import org.junit.Test


class PersonDaoUnitTest {

    private val person = Person(
        firstName = "john",
        lastName = "Doe"
    )

    @Test
    fun `test idGenerator`() {
        assertTrue(
            person.copy(id = idGenerator())
                .id > PERSON_DEFAULT_ID_VALUE
        )
    }


    @Test
    fun `test save une person sans id`() {
        assertEquals(person.id, PERSON_DEFAULT_ID_VALUE)
        assertTrue(save(person).id > PERSON_DEFAULT_ID_VALUE)
    }

    @Test
    fun `test mise à jour de la person à la dernière position`() {
        save(person.copy())
        assertEquals(findAll().last().firstName, person.firstName)
        val newFirstName = "Jane"
        val countBeforeSave = findAll().size
        save(findAll().size - 1, findAll().last().copy(firstName = newFirstName))
        assertEquals(countBeforeSave, findAll().size)
        assertNotEquals(findAll().last().firstName, person.firstName)
    }
}