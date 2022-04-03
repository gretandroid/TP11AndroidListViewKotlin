package education.cccp.tp11listview

import education.cccp.tp11listview.models.Person
import education.cccp.tp11listview.models.Person.Companion.PERSON_DEFAULT_ID_VALUE
import education.cccp.tp11listview.repositories.PersonDao.idGenerator
import education.cccp.tp11listview.repositories.PersonDao.save
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
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
        assertTrue(save(person).id > PERSON_DEFAULT_ID_VALUE)
    }
}