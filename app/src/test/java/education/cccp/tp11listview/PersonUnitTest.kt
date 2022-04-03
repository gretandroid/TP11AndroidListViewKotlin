package education.cccp.tp11listview

import education.cccp.tp11listview.models.Person
import education.cccp.tp11listview.models.Person.Companion.PERSON_DEFAULT_ID_VALUE
import org.junit.Test

import org.junit.Assert.*


class PersonUnitTest {
    private val person = Person(
        firstName = "john",
        lastName = "Doe"
    )
    @Test
    fun `test comportement du constructeur`() {
        assertEquals(person.id, PERSON_DEFAULT_ID_VALUE)
    }
}